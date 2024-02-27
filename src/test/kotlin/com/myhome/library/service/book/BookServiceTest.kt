package com.myhome.library.service.book

import com.myhome.library.dto.book.BookDto
import com.myhome.library.repository.book.BookRepository
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceTest @Autowired constructor(
    private val bookService: BookService,
    private val bookRepository: BookRepository,
) {

    @AfterEach
    fun clean() {
        println("After Clean 시작")
    }

    @Test
    @DisplayName("도서 저장이 정상 동작한다.")
    fun saveBookTest(){
        // given
        val newBook = BookDto("세이노의 가르침", "9412345123451")

        // when
        bookService.saveBook(newBook)

        // then
        val results = bookRepository.findAll()

        AssertionsForInterfaceTypes.assertThat(results).hasSize(1)
        AssertionsForInterfaceTypes.assertThat(results[0].name).isEqualTo("세이노의 가르침")
    }


}
