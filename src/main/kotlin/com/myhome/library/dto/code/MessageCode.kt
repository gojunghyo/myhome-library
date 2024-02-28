package com.myhome.library.dto.code

enum class MessageCode(
     val message: String
) {


    // Success
    SUCCESS_MEMBER_SIGNUP("회원가입이 완료되었습니다."),
    SUCCESS_BOOK_SAVED("도서가 등록되었습니다."),


    // Fail
    IS_NOT_VALID_PHONE("올바른 핸드폰번호를 입력해주세요."),
    IS_NOT_VALID_PASSWORD("비밀번호는 최소6자 이상 10자 이하 영문소문자/대문자/숫자중 2가지 조합이 필요합니다."),
    IS_NOT_VALID_ISBN("도서 등록시 ISBN은 숫자 13자리만 허용 됩니다."),

    IS_NOT_MEMBER("등록 되지 않은 회원 입니다."),

    IS_ENTRUST("이미 위탁 되어있는 도서 입니다."),
    IS_RENTALED("이미 대여 중인 도서 입니다."),


    IS_EXIST_PHONE("이미 등록되어있는 핸드폰 번호입니다."),
    IS_EXIST_ISBN_BOOK("이미 등록되어있는 ISBN 번호입니다."),

}
