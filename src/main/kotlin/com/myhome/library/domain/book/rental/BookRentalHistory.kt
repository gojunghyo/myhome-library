package com.myhome.library.domain.book.rental

import com.myhome.library.domain.member.Member
import com.myhome.library.type.BookRentalStatus
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class BookRentalHistory(
    @ManyToOne
    val member: Member,

    val bookName: String,

    val isbn: String,

    var status: BookRentalStatus = BookRentalStatus.RENTAL,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memberRentalSeq: Long? = null
) {

    fun doReturn() {
        this.status == BookRentalStatus.RETURNED //반납
    }

    companion object {

        fun fixture(
            member: Member,
            bookName: String = "세이노의 가르침",
            isbn: String = "9791168473690",
            status: BookRentalStatus = BookRentalStatus.RENTAL,
            memberRentalSeq: Long? = null,
        ): BookRentalHistory {
            return BookRentalHistory(
                member = member,
                bookName = bookName,
                status = status,
                isbn = isbn,
                memberRentalSeq = memberRentalSeq
            )
        }

    }
}
