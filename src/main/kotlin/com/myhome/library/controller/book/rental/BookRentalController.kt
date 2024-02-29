package com.myhome.library.controller.book.rental

import com.myhome.library.dto.book.RentalDto
import com.myhome.library.dto.code.MessageCode
import com.myhome.library.dto.member.PaginationSupport
import com.myhome.library.dto.member.ResponseDto
import com.myhome.library.service.book.rental.BookRentalService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
@Api(tags = ["도서대여 API"])
class BookRentalController @Autowired constructor(
    private val rentalService: BookRentalService
) {

    private val pageSize = 20

    @GetMapping("/book/rental/list")
    @ApiOperation("대여 가능 도서 목록 Cursor 기반 Paging (20)")
    fun getRentalBooks(@RequestParam cursorId: Long?): ResponseDto {
        val result = rentalService.getRentalAvailableBooks(cursorId)
        if(result.size < pageSize) {
            return ResponseDto(MessageCode.SUCCESS_REQUEST.message, data = result)
        }

        return ResponseDto(MessageCode.SUCCESS_REQUEST.message, PaginationSupport(cursorId), data = result)
    }

    @PostMapping("/book/rental")
    @ApiOperation("도서 대여, [10 ~ 20초 이후 자동 반납]")
    fun bookReturn(@RequestBody rentalDto: RentalDto): ResponseDto{
        rentalService.rentalBook(rentalDto)
        return ResponseDto(MessageCode.SUCCESS_RENTAL_AFTER_RETURNED.message)
    }
}
