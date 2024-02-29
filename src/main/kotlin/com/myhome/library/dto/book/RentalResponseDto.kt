package com.myhome.library.dto.book

import com.myhome.library.domain.book.entrust.BookEntrustHistory

data class RentalResponseDto(
    val bookName: String,
    val memberName: String,
    val isbn: String,
    val rentalPrice: Long,
) {

    companion object {
        fun fixture(
            entrust: BookEntrustHistory
        ): RentalResponseDto {
            return RentalResponseDto(
                bookName = entrust.bookName,
                memberName = entrust.member.name,
                isbn = entrust.isbn,
                rentalPrice = entrust.entrustPrice
            )
        }
    }
}
