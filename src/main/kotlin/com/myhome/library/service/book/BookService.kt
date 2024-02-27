package com.myhome.library.service.book

import com.myhome.library.domain.book.Book
import com.myhome.library.dto.book.BookDto
import com.myhome.library.repository.book.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService @Autowired constructor(
    private val bookRepository: BookRepository,
) {

    @Transactional
    fun saveBook(bookDto: BookDto) {
        val book = Book.fixture(bookDto.name, bookDto.isbn)
        bookRepository.save(book)
    }
}
