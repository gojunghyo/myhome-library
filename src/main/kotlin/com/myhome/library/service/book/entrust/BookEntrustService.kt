package com.myhome.library.service.book.entrust

import com.myhome.library.domain.book.entrust.BookEntrustHistory
import com.myhome.library.dto.book.EntrustDto
import com.myhome.library.dto.code.MessageCode
import com.myhome.library.repository.book.entrust.BookEntrustRepository
import com.myhome.library.service.book.BookService
import com.myhome.library.type.BookEntrustStatus
import com.myhome.library.utils.ValidationHelper
import com.myhome.library.utils.fail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookEntrustService @Autowired constructor(
    private val bookService: BookService,
    private val bookEntrustRepository: BookEntrustRepository,
){

    @Transactional
    fun entrustBook(entrustDto: EntrustDto) {
        if(ValidationHelper.isNotValidIsbn(entrustDto.isbn)) fail(MessageCode.IS_NOT_VALID_ISBN.message)

        if(bookEntrustRepository.find(entrustDto.isbn, BookEntrustStatus.ENTRUST) != null) {
            throw IllegalArgumentException(MessageCode.IS_ENTRUST.message)
        }

        val member = bookService.getMemberByPhone(entrustDto.memberPhone)

        //위탁
        member.entrustBook(
            BookEntrustHistory.fixture(
                member = member,
                bookName = entrustDto.bookName,
                isbn = entrustDto.isbn,
                entrustPrice = entrustDto.enTrustPrice
            ))
    }

}
