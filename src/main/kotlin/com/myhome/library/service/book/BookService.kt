package com.myhome.library.service.book

import com.myhome.library.domain.book.Book
import com.myhome.library.domain.member.Member
import com.myhome.library.dto.book.BookDto
import com.myhome.library.dto.book.EntrustDto
import com.myhome.library.dto.book.RentalDto
import com.myhome.library.dto.code.MessageCode
import com.myhome.library.repository.book.BookRepository
import com.myhome.library.repository.member.MemberRepository
import com.myhome.library.repository.member.entrust.MemberEntrustRepository
import com.myhome.library.repository.member.rental.MemberRentalRepository
import com.myhome.library.type.MemberEntrustStatus
import com.myhome.library.type.MemberRentalStatus
import com.myhome.library.utils.ValidationHelper
import com.myhome.library.utils.fail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService @Autowired constructor(
    private val memberRepository: MemberRepository,
    private val bookRepository: BookRepository,
    private val memberEntrustRepository: MemberEntrustRepository,
    private val memberRentalRepository: MemberRentalRepository,
) {

    @Transactional
    fun saveBook(bookDto: BookDto) {
        if(ValidationHelper.isNotValidIsbn(bookDto.isbn)) fail(MessageCode.IS_NOT_VALID_ISBN.message)
        if(bookRepository.findByIsbn(bookDto.isbn) != null) fail(MessageCode.IS_EXIST_ISBN_BOOK.message)
        val book = Book.fixture(bookDto.bookName, bookDto.isbn)
        bookRepository.save(book)
    }

    @Transactional
    fun entrustBook(entrustDto: EntrustDto) {
        val book = getBookByIsbn(entrustDto.isbn)

        if(memberEntrustRepository.find(entrustDto.isbn, MemberEntrustStatus.ENTRUST) != null) {
            throw IllegalArgumentException(MessageCode.IS_ENTRUST.message)
        }

        val member = getMemberByPhone(entrustDto.memberPhone)

        //위탁
        member.entrustBook(book)
    }

    @Transactional
    fun rentalBook(rentalDto: RentalDto) {
        val book = getBookByIsbn(rentalDto.isbn)

        if(memberRentalRepository.find(rentalDto.isbn, MemberRentalStatus.RENTAL) != null) {
            throw IllegalArgumentException(MessageCode.IS_RENTALED.message)
        }

        val member = getMemberByPhone(rentalDto.memberPhone)

        //대여
        member.rentalBook(book)
    }




    private fun getBookByIsbn(isbn: String): Book {
        return bookRepository.findByIsbn(isbn) ?: fail("등록 되지 않은 도서 입니다.")
    }

    private fun getMemberByPhone(phone: String): Member {
        return memberRepository.findByPhone(phone) ?: fail(MessageCode.IS_NOT_MEMBER.message)
    }
}
