package com.myhome.library.repository.book.rental

import com.myhome.library.domain.book.rental.BookRentalHistory
import org.springframework.data.jpa.repository.JpaRepository

interface BookRentalRepository : JpaRepository<BookRentalHistory, Long>,
    BookRentalRepositoryCustom {
}
