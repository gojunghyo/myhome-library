package com.myhome.library.utils

import org.springframework.stereotype.Component

@Component
class ValidationHelper {

    companion object {
        private val phoneNumberPattern = Regex("^010-[0-9]{4}-[0-9]{4}$")

        /**
         * 최소 하나이상 소문자, 대문자, 숫자 포함, 총길이가 6~10 사이
         * 조합을 사용하여 3가지 경우 [대문자,소문자] | [소문자,숫자] | [대문자,숫자]
         */
        private val passwordPattern = Regex("^(?:(?=.*[a-z])(?=.*[A-Z])|(?=.*[a-z])(?=.*\\d)|(?=.*[A-Z])(?=.*\\d))[a-zA-Z\\d]{6,10}$")

        private val isbnPattern = Regex("^[0-9]{13}$")

        fun isNotValidaPhone(phoneNum: String): Boolean {
            return !phoneNumberPattern.matches(phoneNum)
        }

        fun isNotValidPassword(password: String): Boolean {
            return !passwordPattern.matches(password)
        }

        fun isNotValidIsbn(isbn: String): Boolean {
            return !isbnPattern.matches(isbn)
        }
    }
}
