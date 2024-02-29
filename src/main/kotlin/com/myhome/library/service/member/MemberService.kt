package com.myhome.library.service.member

import com.myhome.library.domain.member.Member
import com.myhome.library.dto.code.MessageCode
import com.myhome.library.dto.member.MemberDto
import com.myhome.library.dto.member.MemberResponseDto
import com.myhome.library.dto.member.ResponseDto
import com.myhome.library.repository.member.MemberRepository
import com.myhome.library.utils.ValidationHelper
import com.myhome.library.utils.fail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.streams.toList

@Service
class MemberService @Autowired constructor(
    private val memberRepository: MemberRepository,
){

    @Transactional
    fun saveUser(memberDto: MemberDto): ResponseDto {
        if(ValidationHelper.isNotValidPassword(memberDto.password)) fail(MessageCode.IS_NOT_VALID_PASSWORD.message)
        if(ValidationHelper.isNotValidaPhone(memberDto.phone)) fail(MessageCode.IS_NOT_VALID_PHONE.message)
        if(memberRepository.findByPhone(memberDto.phone) != null) fail(MessageCode.IS_EXIST_PHONE.message)

        val newMember = Member(memberDto.name, memberDto.email, memberDto.phone, memberDto.password)
        memberRepository.save(newMember)

        return ResponseDto(MessageCode.SUCCESS_MEMBER_SIGNUP.message)
    }

    @Transactional(readOnly = true)
    fun getMembers(): List<MemberResponseDto> {
       return memberRepository.findAll()
           .stream()
           .map { member -> MemberResponseDto.fixture(member) }
           .toList()
    }
}
