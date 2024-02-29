package com.myhome.library.controller.book.rental

import com.myhome.library.dto.code.MessageCode
import com.myhome.library.dto.member.ResponseDto
import com.myhome.library.service.book.rental.BookRentalService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
@Api(tags = ["도서대여 API"])
class BookRentalController @Autowired constructor(
    private val rentalService: BookRentalService
) {

    @GetMapping("/book/rental/list")
    @ApiOperation("대여 가능 도서 목록 Cursor 기반 Paging (20)")
    fun getRentalBooks(@RequestParam cursorId: Long?): ResponseDto {
        val result = rentalService.getRentalAvailableBooks(cursorId)
        return ResponseDto(MessageCode.SUCCESS_REQUEST.message, data = result)
    }
}
