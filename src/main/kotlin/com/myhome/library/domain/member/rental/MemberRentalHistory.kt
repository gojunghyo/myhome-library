package com.myhome.library.domain.member.rental

import com.myhome.library.domain.member.Member
import com.myhome.library.type.MemberRentalStatus
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class MemberRentalHistory(
    @ManyToOne
    val member: Member,

    val bookName: String,

    val isbn: String,

    var status: MemberRentalStatus = MemberRentalStatus.RENTAL,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memberRentalSeq: Long? = null
) {

    fun doReturn() {
        this.status == MemberRentalStatus.RETURNED //반납
    }

    companion object {

        fun fixture(
            member: Member,
            bookName: String = "세이노의 가르침",
            isbn: String = "9791168473690",
            status: MemberRentalStatus = MemberRentalStatus.RENTAL,
            memberRentalSeq: Long? = null,
        ): MemberRentalHistory {
            return MemberRentalHistory(
                member = member,
                bookName = bookName,
                status = status,
                isbn = isbn,
                memberRentalSeq = memberRentalSeq
            )
        }

    }
}
