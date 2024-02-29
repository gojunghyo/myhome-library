package com.myhome.library.service.book

import com.myhome.library.domain.book.Book
import com.myhome.library.domain.member.Member
import com.myhome.library.dto.book.BookDto
import com.myhome.library.dto.book.RentalDto
import com.myhome.library.repository.book.BookRepository
import com.myhome.library.repository.member.MemberRepository
import com.myhome.library.repository.book.rental.BookRentalRepository
import com.myhome.library.service.book.rental.BookRentalService
import com.myhome.library.type.BookRentalStatus
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceTest @Autowired constructor(
    private val bookService: BookService,
    private val bookRepository: BookRepository,
    private val bookRentalService: BookRentalService,
    private val bookRentalRepository: BookRentalRepository,
    private val memberRepository: MemberRepository,
) {

    @BeforeEach
    fun clean() {
        println("Before Clean 시작")
        memberRepository.deleteAll()
        bookRepository.deleteAll()
    }

    @Test
    @DisplayName("도서 저장이 정상 동작한다.")
    fun saveBookTest(){
        // given
        val newBook = BookDto(bookName = "세이노의 가르침", isbn = "9791168473690")

        // when
        bookService.saveBook(newBook)

        // then
        val results = bookRepository.findAll()

        assertThat(results).hasSize(1)
        assertThat(results[0].name).isEqualTo("세이노의 가르침")
    }

    @Test
    @DisplayName("도서 대여가 정상 동작한다.")
    fun rentalBookTest() {
        // given
        bookRepository.save(Book.fixture("세이노의 가르침", "9791168473690"))
        val savedMember = memberRepository.save(Member.fixture("고정효", phone = "010-1234-1234"))
        val rentalDto = RentalDto("세이노의 가르침", "010-1234-1234", "9791168473690")

        // when
        bookRentalService.rentalBook(rentalDto)

        // then
        val result = bookRentalRepository.findAll()
        assertThat(result).hasSize(1)
        assertThat(result[0].bookName).isEqualTo("세이노의 가르침")
        assertThat(result[0].member.memberSeq).isEqualTo(savedMember.memberSeq)
        assertThat(result[0].status).isEqualTo(BookRentalStatus.RENTAL)
    }
}
