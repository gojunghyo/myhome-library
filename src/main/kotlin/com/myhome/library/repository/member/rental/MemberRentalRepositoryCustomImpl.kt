package com.myhome.library.repository.member.rental

import com.myhome.library.domain.member.rental.MemberRentalHistory
import com.myhome.library.domain.member.rental.QMemberRentalHistory.memberRentalHistory
import com.myhome.library.type.MemberRentalStatus
import com.querydsl.jpa.impl.JPAQueryFactory

class MemberRentalRepositoryCustomImpl (
    private val queryFactory: JPAQueryFactory
) : MemberRentalRepositoryCustom {

    override fun find(isbn: String, status: MemberRentalStatus): MemberRentalHistory? {
        return queryFactory.select(memberRentalHistory)
            .from(memberRentalHistory)
            .where(
                memberRentalHistory.isbn.eq(isbn),
                memberRentalHistory.status.eq(status),
            )
            .limit(1)
            .fetchOne()
    }


}
