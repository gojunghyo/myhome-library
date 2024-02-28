package com.myhome.library.service.member

import com.myhome.library.dto.member.MemberDto
import com.myhome.library.repository.member.MemberRepository
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
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
        memberRepository.deleteAll()
    }


    @Test
    @DisplayName("회원가입이 정상 동작한다.")
    fun saveUserTest(){
        // given
        val newUser = MemberDto("고정효", "gojgho@naver.com", "010-1234-1234", "A123456b")

        // when
        memberService.saveUser(newUser)

        // then
        val results = memberRepository.findAll()

        assertThat(results).hasSize(1)
        assertThat(results[0].name).isEqualTo("고정효")
    }


    @Test
    @DisplayName("회원가입시 올바른 패스워드가 아니라면 예외가 발생한다.")
    fun saveUserValidationPasswordTest(){
        assertThrows<IllegalArgumentException> {
            // given
            val newUser = MemberDto("고정효", "gojgho@naver.com", "010-1234-1234", "123")

            // when, then
            memberService.saveUser(newUser)
        }
    }

    @Test
    @DisplayName("회원가입시 올바른 핸드폰번호가 아니라면 예외가 발생한다.")
    fun saveUserValidationPhoneTest(){

        assertThrows<IllegalArgumentException> {
            // given
            val newUser = MemberDto("고정효", "gojgho@naver.com", "010-xxxx-aaaa", "A123456b")

            // when, then
            memberService.saveUser(newUser)
        }
    }

}
