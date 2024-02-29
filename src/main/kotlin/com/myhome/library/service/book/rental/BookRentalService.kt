package com.myhome.library.service.book.rental

import com.myhome.library.domain.book.entrust.BookEntrustHistory
import com.myhome.library.domain.member.Member
import com.myhome.library.dto.book.RentalDto
import com.myhome.library.dto.book.RentalResponseDto
import com.myhome.library.dto.code.MessageCode
import com.myhome.library.repository.book.entrust.BookEntrustRepository
import com.myhome.library.repository.book.rental.BookRentalRepository
import com.myhome.library.service.book.BookService
import com.myhome.library.service.member.MemberService
import com.myhome.library.type.BookRentalStatus
import com.myhome.library.utils.fail
import com.myhome.library.utils.logger
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.streams.toList

@Service
class BookRentalService @Autowired constructor(
    private val bookService: BookService,
    private val bookRentalRepository: BookRentalRepository,
    private val bookEntrustRepository: BookEntrustRepository,
) {

    private val log = logger()



    @Transactional(readOnly = true)
    fun getRentalAvailableBooks(cursorId: Long?): List<RentalResponseDto> {
        return bookEntrustRepository.findRentalAvailableBooks(cursorId)
            .stream()
            .map { entrust -> RentalResponseDto.fixture(entrust) }
            .toList()

    }

    @Transactional
    fun rentalBook(rentalDto: RentalDto) {
        //위탁된 도서 찾은후
        val rentalAvailableBook = bookEntrustRepository.getEntrustBookByIsbn(rentalDto.isbn) ?: fail(MessageCode.IS_NOT_EXIST_ENTRUST.message)

        //대여가 이미 되어있지 않을때
        if(bookRentalRepository.find(rentalDto.isbn, BookRentalStatus.RENTAL) != null) {
            throw IllegalArgumentException(MessageCode.IS_RENTALED.message)
        }

        //대여자 폰번호로 회원 조회후
        val member = bookService.getMemberByPhone(rentalDto.memberPhone)

        val returnInProgressFlag = returnInProgressMap.computeIfAbsent(rentalAvailableBook.isbn) { AtomicBoolean(false) }
        if (returnInProgressFlag.compareAndSet(false, true)) {
            try {
            //대여 내역에 저장
            member.rentalBook(rentalAvailableBook)

            //  10 to 20 seconds
            val delayTime = (10000L..20000L).random()
            asyncRentalBookToReturned(member, rentalAvailableBook, delayTime)
            } finally {
                // 처리가 완료되면 플래그를 다시 false로 설정
                returnInProgressFlag.set(false)
            }
        } else {
            fail("ISBN = [${rentalAvailableBook.isbn}] 도서는 대여 중 입니다, (20초 이내로 반납이 완료됩니다).")
        }
    }

    fun asyncRentalBookToReturned(member: Member, rentalAvailableBook: BookEntrustHistory, delayTime: Long): Unit = runBlocking {
        launch {
            log.info("대기시간 = $delayTime , 반납중인 도서 ISBN = ${rentalAvailableBook.isbn}")
            delay(delayTime)
            member.returnBook(rentalAvailableBook)
            log.info("반납완료 되었습니다.")
        }
    }

    companion object{
        /**
         * 반납처리가 시작되면 플래그를 true로 설정, 처리가 완료되면 다시 false로 설정합니다.
         * 플래그가 이미 true인 경우에는 함수가 요청을 무시하여 동일한 도서에 대한 여러번 호출을 방지합니다.
         */
        private val returnInProgressMap: MutableMap<String, AtomicBoolean> = mutableMapOf()

    }
}
