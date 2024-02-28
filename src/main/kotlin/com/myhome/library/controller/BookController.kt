package com.myhome.library.controller

import com.myhome.library.dto.book.BookDto
import com.myhome.library.dto.code.MessageCode
import com.myhome.library.dto.member.ResponseDto
import com.myhome.library.service.book.BookService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
@Api(tags = ["도서 API"])
class BookController @Autowired constructor(
    private val bookService: BookService,
) {

    @PostMapping("/book")
    @ApiOperation("도서 등록 API")
    fun saveBook(@RequestBody request: BookDto): ResponseDto {
        bookService.saveBook(request)
        return ResponseDto(MessageCode.SUCCESS_BOOK_SAVED.message)
    }

}
