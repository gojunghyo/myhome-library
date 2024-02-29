package com.myhome.library.dto.member

data class ResponseDto(
    val message: String?,
    val cursor: PaginationSupport? = null,
    val data: Any? = null,
)

data class PaginationSupport(
    var nextCursor: Long?
) {
    init {
        nextCursor = nextCursor?.plus(20)
    }
}
