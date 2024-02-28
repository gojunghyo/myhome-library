package com.myhome.library.domain.member.entrust

import com.myhome.library.domain.member.Member
import com.myhome.library.type.MemberEntrustStatus
import javax.persistence.*

@Entity
class MemberEntrustHistory(
    @ManyToOne
    val member: Member,

    val bookName: String,

    val isbn: String,

    var status: MemberEntrustStatus = MemberEntrustStatus.ENTRUST, //위탁중

    val entrustPrice: Long = 0,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memberEntrustSeq: Long? = null
) {

    val isEntrust: Boolean
        get() = this.status == MemberEntrustStatus.POSSESSION

    //소유중
    fun doPossession() {
        this.status == MemberEntrustStatus.POSSESSION
    }

    companion object {
        fun fixture(
            member: Member,
            bookName: String = "세이노의 가르침",
            isbn: String = "9791168473690",
            status: MemberEntrustStatus = MemberEntrustStatus.ENTRUST, //위탁중
            entrustPrice: Long = 0,
            memberEntrustSeq: Long? = null,
        ): MemberEntrustHistory {
            return MemberEntrustHistory(
                member = member,
                bookName = bookName,
                isbn = isbn,
                status = status,
                entrustPrice = entrustPrice,
                memberEntrustSeq = memberEntrustSeq,
            )
        }

    }
}
