package com.myhome.library.repository.member

import com.myhome.library.domain.member.Member
import com.myhome.library.domain.member.QMember.member
import com.myhome.library.domain.member.entrust.QMemberEntrustHistory.memberEntrustHistory
import com.myhome.library.domain.member.rental.QMemberRentalHistory.memberRentalHistory

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.beans.factory.annotation.Autowired

class MemberRepositoryCustomImpl @Autowired constructor(
    private val queryFactory: JPAQueryFactory
) : MemberRepositoryCustom {


    override fun findAllWithRentalHistories(): List<Member> {
        return queryFactory.select(member).distinct()
            .from(member)
            .leftJoin(memberRentalHistory)
            .on(memberRentalHistory.member.memberSeq.eq(member.memberSeq))
            .fetchJoin()
            .fetch()
    }

    override fun findAllWithEntrustHistories(): List<Member> {
       return queryFactory.select(member).distinct()
           .from(member)
           .leftJoin(memberEntrustHistory)
           .on(memberEntrustHistory.member.memberSeq.eq(member.memberSeq))
           .fetchJoin()
           .fetch()
    }

}
