package com.myhome.library.controller.book.rental

import com.myhome.library.service.book.rental.BookRentalService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
@Api(tags = ["도서대여 API"])
class BookRentalController @Autowired constructor(
    private val rentalService: BookRentalService
) {

    @GetMapping("/book/rental/list")
    @ApiOperation("대여 가능 도서 목록")
    fun getRentalBooks() {
        rentalService.getRentalAvailableBooks()
    }
}
