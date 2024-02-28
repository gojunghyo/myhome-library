package com.myhome.library.dto.book

//위탁
data class EntrustDto(
     val bookName: String,
     val memberPhone: String,
     val isbn: String,
     val enTrustPrice: Long,
)
