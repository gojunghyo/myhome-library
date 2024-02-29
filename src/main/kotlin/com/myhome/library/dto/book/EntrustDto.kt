package com.myhome.library.dto.book

import com.myhome.library.domain.book.entrust.BookEntrustHistory

//위탁
data class EntrustDto(
     val bookName: String,
     val memberPhone: String,
     val isbn: String,
     val enTrustPrice: Long,
) {


     companion object {
          fun fixture(
               entrust: BookEntrustHistory
          ): EntrustDto {
               return EntrustDto(
                    bookName = entrust.bookName,
                    memberPhone = entrust.member.phone,
                    isbn = entrust.isbn,
                    enTrustPrice = entrust.entrustPrice
               )
          }
     }
}
