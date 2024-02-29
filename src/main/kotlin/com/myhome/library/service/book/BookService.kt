package com.myhome.library.service.book

import com.myhome.library.domain.book.Book
import com.myhome.library.domain.member.Member
import com.myhome.library.dto.book.BookDto
import com.myhome.library.dto.code.MessageCode
import com.myhome.library.repository.book.BookRepository
import com.myhome.library.repository.member.MemberRepository
import com.myhome.library.utils.ValidationHelper
import com.myhome.library.utils.fail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.streams.toList

@Service
class BookService @Autowired constructor(
    private val memberRepository: MemberRepository,
    private val bookRepository: BookRepository,
) {

    @Transactional
    fun saveBook(bookDto: BookDto) {
        if(ValidationHelper.isNotValidIsbn(bookDto.isbn)) fail(MessageCode.IS_NOT_VALID_ISBN.message)
        if(bookRepository.findByIsbn(bookDto.isbn) != null) fail(MessageCode.IS_EXIST_ISBN_BOOK.message)
        val book = Book.fixture(bookDto.bookName, bookDto.isbn)
        bookRepository.save(book)
    }

    @Transactional(readOnly = true)
    fun getBooks(cursorId: Long?): List<BookDto> {

        return bookRepository.getBooks(cursorId)
            .stream()
            .map { book -> BookDto.fixture(book) }
            .toList()
    }

    fun getBookByIsbn(isbn: String): Book {
        return bookRepository.findByIsbn(isbn) ?: fail("등록 되지 않은 도서 입니다.")
    }

    fun getMemberByPhone(phone: String): Member {
        return memberRepository.findByPhone(phone) ?: fail(MessageCode.IS_NOT_MEMBER.message)
    }

}
