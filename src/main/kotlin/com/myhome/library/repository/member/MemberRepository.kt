package com.myhome.library.repository.member

import com.myhome.library.domain.member.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> , MemberRepositoryCustom {

    fun findByPhone(phone: String): Member?
}
