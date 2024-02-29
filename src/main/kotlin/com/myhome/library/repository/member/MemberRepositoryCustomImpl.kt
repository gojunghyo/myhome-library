package com.myhome.library.repository.member

import com.myhome.library.domain.book.entrust.QBookEntrustHistory.bookEntrustHistory
import com.myhome.library.domain.book.rental.QBookRentalHistory.bookRentalHistory
import com.myhome.library.domain.member.Member
import com.myhome.library.domain.member.QMember.member

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.beans.factory.annotation.Autowired

class MemberRepositoryCustomImpl @Autowired constructor(
    private val queryFactory: JPAQueryFactory
) : MemberRepositoryCustom {


    override fun findAllWithRentalHistories(): List<Member> {
        return queryFactory.select(member).distinct()
            .from(member)
            .leftJoin(bookRentalHistory)
            .on(bookRentalHistory.member.memberSeq.eq(member.memberSeq))
            .fetchJoin()
            .fetch()
    }

    override fun findAllWithEntrustHistories(): List<Member> {
       return queryFactory.select(member).distinct()
           .from(member)
           .leftJoin(bookEntrustHistory)
           .on(bookEntrustHistory.member.memberSeq.eq(member.memberSeq))
           .fetchJoin()
           .fetch()
    }

}
