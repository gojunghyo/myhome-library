package com.myhome.library.domain.member

import com.myhome.library.domain.book.Book
import com.myhome.library.domain.member.entrust.MemberEntrustHistory
import com.myhome.library.domain.member.rental.MemberRentalHistory
import javax.persistence.Entity
import javax.persistence.*

@Entity
class Member(
    val name: String,
    val email: String,
    val phone: String,
    val password: String,

    @OneToMany(mappedBy = "member", cascade = [CascadeType.ALL], orphanRemoval = true)
    val memberRentalHistoies: MutableList<MemberRentalHistory> = mutableListOf(),

    @OneToMany(mappedBy = "member", cascade = [CascadeType.ALL], orphanRemoval = true)
    val memberEntrustHistories: MutableList<MemberEntrustHistory> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memberSeq: Long? = null
) {

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어있을수 없습니다.")
        }
    }

    fun rentalBook(book: Book) {
        this.memberRentalHistoies.add(MemberRentalHistory.fixture(this, book.name, book.isbn)) // 대여중
    }

    fun returnBook(bookIsbn: String) {
        this.memberRentalHistoies.first { rentalBook -> rentalBook.isbn == bookIsbn }.doReturn() // 반납으로 변경
    }

    fun entrustBook(book: Book) {
        this.memberEntrustHistories.add(MemberEntrustHistory.fixture(this, book.name, book.isbn)) //위탁중
    }

    fun possessionBook(bookIsbn: String) {
        this.memberEntrustHistories.first{ entrustBook -> entrustBook.isbn == bookIsbn }.doPossession() //소유로 변경
    }


    companion object {
        fun fixture(
             name: String = "고정효",
             email: String = "gojgho@naver.com",
             phone: String = "010-1234-1234",
             password: String = "AAbb1234"
        ): Member {
            return Member(
                name = name,
                email = email,
                phone = phone,
                password = password,
            )
        }
    }
}
