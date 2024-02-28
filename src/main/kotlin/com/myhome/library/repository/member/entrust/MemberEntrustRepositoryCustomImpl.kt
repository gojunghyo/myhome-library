package com.myhome.library.repository.member.entrust

import com.myhome.library.domain.member.entrust.MemberEntrustHistory
import com.myhome.library.domain.member.entrust.QMemberEntrustHistory.memberEntrustHistory
import com.myhome.library.type.MemberEntrustStatus
import com.querydsl.jpa.impl.JPAQueryFactory

class MemberEntrustRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
) : MemberEntrustRepositoryCustom {

    override fun find(isbn: String, status: MemberEntrustStatus): MemberEntrustHistory? {
        return queryFactory.select(memberEntrustHistory)
            .from(memberEntrustHistory)
            .where(
                memberEntrustHistory.isbn.eq(isbn),
                memberEntrustHistory.status.eq(status)
            )
            .limit(1)
            .fetchOne()
    }
}
