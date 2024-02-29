package com.myhome.library.domain.member

import com.myhome.library.domain.book.entrust.BookEntrustHistory
import com.myhome.library.domain.book.rental.BookRentalHistory
import com.myhome.library.type.BookRentalStatus

import javax.persistence.Entity
import javax.persistence.*

@Entity
class Member(
    val name: String,
    val email: String,
    val phone: String,
    val password: String,

    @OneToMany(mappedBy = "member", cascade = [CascadeType.ALL], orphanRemoval = true)
    val bookRentalHistoies: MutableList<BookRentalHistory> = mutableListOf(),

    @OneToMany(mappedBy = "member", cascade = [CascadeType.ALL], orphanRemoval = true)
    val bookEntrustHistories: MutableList<BookEntrustHistory> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memberSeq: Long? = null
) {

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어있을수 없습니다.")
        }
    }

    fun rentalBook(rentalBook: BookEntrustHistory) {
        rentalBook.increaseRentalCount()
        this.bookRentalHistoies.add(BookRentalHistory.fixture(this, rentalBook.bookName, rentalBook.isbn)) // 대여중
    }

    fun returnBook(returnedBook: BookEntrustHistory) {

        this.bookRentalHistoies.first { rentalBook -> rentalBook.isbn == returnedBook.isbn
                &&
                rentalBook.status == BookRentalStatus.RENTAL
        }.doReturn() // 반납으로 변경
    }

    fun entrustBook(entrustBook: BookEntrustHistory) {
        this.bookEntrustHistories.add(entrustBook) //위탁중
    }

    fun possessionBook(bookIsbn: String) {
        this.bookEntrustHistories.first{ entrustBook -> entrustBook.isbn == bookIsbn }.doPossession() //소유로 변경
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
