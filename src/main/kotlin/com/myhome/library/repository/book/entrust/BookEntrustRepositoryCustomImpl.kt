package com.myhome.library.repository.book.entrust


import com.myhome.library.domain.book.entrust.BookEntrustHistory
import com.myhome.library.domain.book.entrust.QBookEntrustHistory.bookEntrustHistory
import com.myhome.library.type.BookEntrustStatus
import com.querydsl.jpa.impl.JPAQueryFactory

class BookEntrustRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
) : BookEntrustRepositoryCustom {

    override fun find(isbn: String, status: BookEntrustStatus): BookEntrustHistory? {
        return queryFactory.select(bookEntrustHistory)
            .from(bookEntrustHistory)
            .where(
                bookEntrustHistory.isbn.eq(isbn),
                bookEntrustHistory.status.eq(status)
            )
            .limit(1)
            .fetchOne()
    }

    override fun findRentalAvailableBooks(cursorId: Long?): List<BookEntrustHistory> {
        return queryFactory.select(bookEntrustHistory)
            .from(bookEntrustHistory)
            .where(
                bookEntrustHistory.bookEntrustSeq.gt(cursorId),
                bookEntrustHistory.status.eq(BookEntrustStatus.ENTRUST)
            )
            .fetch()
    }
}
