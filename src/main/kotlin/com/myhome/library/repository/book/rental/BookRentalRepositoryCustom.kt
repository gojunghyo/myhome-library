package com.myhome.library.repository.book.rental

import com.myhome.library.domain.book.rental.BookRentalHistory
import com.myhome.library.type.BookRentalStatus

interface BookRentalRepositoryCustom {
    fun find(isbn: String, status: BookRentalStatus): BookRentalHistory?


    fun bookStatusIsRental(isbn: String, status: BookRentalStatus): BookRentalHistory?

}
