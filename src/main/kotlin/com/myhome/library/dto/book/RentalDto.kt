package com.myhome.library.dto.book

//대여
data class RentalDto(
    val bookName: String,
    val memberPhone: String,
    val isbn: String,
)
