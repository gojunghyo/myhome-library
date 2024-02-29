package com.myhome.library.repository.book

import com.myhome.library.domain.book.Book
import com.myhome.library.domain.book.QBook.book
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.beans.factory.annotation.Autowired


class BookRepositoryCustomImpl @Autowired constructor(
    private val queryFactory: JPAQueryFactory,
) : BookRepositoryCustom {


    override fun getBooks(cursor: Long?): List<Book> {
        return queryFactory.select(book)
            .from(book)
            .where(
                book.bookSeq.gt(cursor)
            )
            .limit(20)
            .orderBy(book.bookSeq.asc())
            .fetch()
    }
}
