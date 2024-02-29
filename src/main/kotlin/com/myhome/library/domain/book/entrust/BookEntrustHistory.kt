package com.myhome.library.domain.book.entrust

import com.myhome.library.domain.member.Member
import com.myhome.library.type.BookEntrustStatus
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class BookEntrustHistory(
    @ManyToOne
    val member: Member,

    val bookName: String,

    val isbn: String,

    @Enumerated(EnumType.STRING)
    var status: BookEntrustStatus = BookEntrustStatus.ENTRUST, //위탁중

    val entrustPrice: Long = 0,

    var rentalCount: Long = 0,

    @Column(nullable = true)
    val registrationDate: LocalDateTime? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val bookEntrustSeq: Long? = null
) {

    val isEntrust: Boolean
        get() = this.status == BookEntrustStatus.POSSESSION

    //소유중 으로 변경
    fun doPossession() {
        this.status = BookEntrustStatus.POSSESSION
    }

    // 대여 카운트 증가
    fun increaseRentalCount() {
        this.rentalCount++
    }


    companion object {
        fun fixture(
            member: Member,
            bookName: String = "세이노의 가르침",
            isbn: String = "9791168473690",
            status: BookEntrustStatus = BookEntrustStatus.ENTRUST, //위탁중
            entrustPrice: Long = 0,
            rentalCount: Long = 0,
            registrationDate: LocalDateTime? = LocalDateTime.now(),
            bookEntrustSeq: Long? = null,
        ): BookEntrustHistory {
            return BookEntrustHistory(
                member = member,
                bookName = bookName,
                isbn = isbn,
                status = status,
                entrustPrice = entrustPrice,
                rentalCount = rentalCount,
                registrationDate = registrationDate,
                bookEntrustSeq = bookEntrustSeq,
            )
        }

    }
}
