package com.myhome.library.controller.member

import com.myhome.library.dto.code.MessageCode
import com.myhome.library.dto.member.MemberDto
import com.myhome.library.dto.member.ResponseDto
import com.myhome.library.service.member.MemberService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
@Api(tags = ["회원 API"])
class MemberController @Autowired constructor(
    private val memberService: MemberService,
) {

    @PostMapping("/member")
    @ApiOperation("회원 가입")
    fun saveMember(@RequestBody memberDto: MemberDto): ResponseDto {
        memberService.saveUser(memberDto)
        return ResponseDto(MessageCode.SUCCESS_MEMBER_SIGNUP.message)
    }

    @GetMapping("/members")
    @ApiOperation("전체 회원 리스트")
    fun getMembers(): ResponseDto {
        val result = memberService.getMembers()
        return ResponseDto(MessageCode.SUCCESS_REQUEST.message, data = result)
    }
}
