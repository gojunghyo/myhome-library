package com.myhome.library.service.member

import com.myhome.library.domain.member.Member
import com.myhome.library.dto.member.MemberDto
import com.myhome.library.repository.member.MemberRepository
import com.myhome.library.utils.logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService @Autowired constructor(
    private val memberRepository: MemberRepository,
){

    private val log = logger()

    @Transactional
    fun saveUser(memberDto: MemberDto) {
        val newMember = Member(memberDto.name, memberDto.email, memberDto.phone, memberDto.password)
        memberRepository.save(newMember)
    }


}
