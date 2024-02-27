package com.myhome.library.service.member

import com.myhome.library.dto.member.MemberDto
import com.myhome.library.repository.member.MemberRepository
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberServiceTest @Autowired constructor(
    val memberService: MemberService,
    val memberRepository: MemberRepository,
) {


    @AfterEach
    fun clean() {
        println("After Clean 시작")
    }


    @Test
    @DisplayName("회원 저장이 정상 동작한다.")
    fun saveUserTest(){
        // given
        val newUser = MemberDto("고정효", "gojgho@naver.com", "010-5746-3317", "123")

        // when
        memberService.saveUser(newUser)

        // then
        val results = memberRepository.findAll()

        assertThat(results).hasSize(1)
        assertThat(results[0].name).isEqualTo("고정효")
    }
}
