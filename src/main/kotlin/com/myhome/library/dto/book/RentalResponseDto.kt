package com.myhome.library.dto.book

import com.myhome.library.domain.book.entrust.BookEntrustHistory
import java.time.LocalDateTime

data class RentalResponseDto(
    val bookName: String,
    val memberName: String,
    val isbn: String,
    val rentalPrice: Long,
    val rentalCount: Long,
    val registrationDate: LocalDateTime?
) {

    companion object {
        fun fixture(
            entrust: BookEntrustHistory
        ): RentalResponseDto {
            return RentalResponseDto(
                bookName = entrust.bookName,
                memberName = entrust.member.name,
                isbn = entrust.isbn,
                rentalPrice = entrust.entrustPrice,
                rentalCount = entrust.rentalCount,
                registrationDate = entrust.registrationDate,
            )
        }
    }
}
