package com.myhome.library.repository.member

import com.myhome.library.domain.member.Member

interface MemberRepositoryCustom {

    fun findAllWithRentalHistories(): List<Member>

    fun findAllWithEntrustHistories(): List<Member>

}
