package com.myhome.library.repository.book.rental

import com.myhome.library.domain.book.rental.BookRentalHistory
import com.myhome.library.domain.book.rental.QBookRentalHistory.bookRentalHistory
import com.myhome.library.type.BookRentalStatus
import com.querydsl.jpa.impl.JPAQueryFactory

class BookRentalRepositoryCustomImpl (
    private val queryFactory: JPAQueryFactory
) : BookRentalRepositoryCustom {

    override fun find(isbn: String, status: BookRentalStatus): BookRentalHistory? {
        return queryFactory.select(bookRentalHistory)
            .from(bookRentalHistory)
            .where(
                bookRentalHistory.isbn.eq(isbn),
                bookRentalHistory.status.eq(status),
            )
            .limit(1)
            .fetchOne()
    }

    override fun bookStatusIsRental(isbn: String, status: BookRentalStatus): BookRentalHistory? {
        TODO("Not yet implemented")
    }


}
