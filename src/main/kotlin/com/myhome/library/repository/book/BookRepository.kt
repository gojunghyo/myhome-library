package com.myhome.library.repository.book

import com.myhome.library.domain.book.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long> , BookRepositoryCustom {

    fun findByIsbn(isbn: String): Book?
}
