package com.myhome.library.service.book.rental

import com.myhome.library.dto.book.RentalDto
import com.myhome.library.dto.code.MessageCode
import com.myhome.library.repository.book.entrust.BookEntrustRepository
import com.myhome.library.repository.book.rental.BookRentalRepository
import com.myhome.library.service.book.BookService
import com.myhome.library.type.BookRentalStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookRentalService @Autowired constructor(
    private val bookService: BookService,
    private val bookRentalRepository: BookRentalRepository,
    private val bookEntrustRepository: BookEntrustRepository,
) {

    @Transactional
    fun rentalBook(rentalDto: RentalDto) {
        val book = bookService.getBookByIsbn(rentalDto.isbn)

        if(bookRentalRepository.find(rentalDto.isbn, BookRentalStatus.RENTAL) != null) {
            throw IllegalArgumentException(MessageCode.IS_RENTALED.message)
        }

        val member = bookService.getMemberByPhone(rentalDto.memberPhone)

        //대여
        member.rentalBook(book)
    }

    @Transactional(readOnly = true)
    fun getRentalAvailableBooks() {


    }

}
