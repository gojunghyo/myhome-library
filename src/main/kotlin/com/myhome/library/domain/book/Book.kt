package com.myhome.library.domain.book

import com.myhome.library.type.BookType
import javax.persistence.*

@Entity
class Book(
    val name: String,

    val isbn: String,

    @Enumerated(EnumType.STRING)
    val type: BookType,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val bookSeq: Long? = null
) {

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다");
        }
    }

    companion object {
        fun fixture(
            name: String = "세이노의 가르침",
            isbn: String = "9791168473690",
            type: BookType = BookType.COMPUTER,
            bookSeq: Long? = null
        ): Book {
            return Book(
                name = name,
                isbn = isbn,
                type = type,
                bookSeq = bookSeq
            )
        }
    }
}
