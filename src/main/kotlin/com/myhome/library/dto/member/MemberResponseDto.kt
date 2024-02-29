package com.myhome.library.dto.member

import com.myhome.library.domain.member.Member

data class MemberResponseDto(
    val name: String,
    val email: String,
    val phone: String,
) {
    companion object {
        fun fixture(
            member: Member
        ): MemberResponseDto {
            return MemberResponseDto (
                name = member.name,
                email = member.email,
                phone = member.phone,
            )
        }
    }
}
