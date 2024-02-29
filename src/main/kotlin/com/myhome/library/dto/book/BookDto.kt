package com.myhome.library.dto.book

import com.myhome.library.domain.book.Book


data class BookDto(
    val bookName: String,
    val isbn: String,
) {




    companion object {
        fun fixture(
            book: Book
        ): BookDto {
            return BookDto(book.name, book.isbn)
        }
    }
}
