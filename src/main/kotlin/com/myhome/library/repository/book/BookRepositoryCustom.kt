package com.myhome.library.repository.book

import com.myhome.library.domain.book.Book


interface BookRepositoryCustom {

    fun getBooks(cursor: Long?): List<Book>
}
