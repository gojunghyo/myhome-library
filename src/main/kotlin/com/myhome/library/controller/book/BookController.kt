package com.myhome.library.controller.book

import com.myhome.library.dto.book.BookDto
import com.myhome.library.dto.code.MessageCode
import com.myhome.library.dto.member.PaginationSupport
import com.myhome.library.dto.member.ResponseDto
import com.myhome.library.service.book.BookService
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
@Api(tags = ["도서 API"])
class BookController @Autowired constructor(
    private val bookService: BookService,
) {

    private val pageSize = 20

    @PostMapping("/book")
    @ApiOperation("도서 등록")
    fun saveBook(@RequestBody request: BookDto): ResponseDto {
        bookService.saveBook(request)
        return ResponseDto(MessageCode.SUCCESS_BOOK_SAVED.message)
    }

    @GetMapping("/book/lists")
    @ApiOperation("전체 도서 확인 Cursor 기반 Paging (20)")
    fun getBooks(@RequestParam cursorId: Long?): ResponseDto {
        val result = bookService.getBooks(cursorId)
        if(result.size < pageSize) {
          return ResponseDto(MessageCode.SUCCESS_REQUEST.message,null, result)
        }

        return ResponseDto(MessageCode.SUCCESS_REQUEST.message, PaginationSupport(cursorId), result)
    }
}
