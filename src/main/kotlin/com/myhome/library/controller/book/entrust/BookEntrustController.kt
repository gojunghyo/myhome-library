package com.myhome.library.controller.book.entrust

import com.myhome.library.dto.book.EntrustDto
import com.myhome.library.dto.code.MessageCode
import com.myhome.library.dto.member.ResponseDto
import com.myhome.library.service.book.entrust.BookEntrustService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1")
@Api(tags = ["도서위탁 API"])
class BookEntrustController @Autowired constructor(
    private val bookEntrustService: BookEntrustService,
) {

    @PostMapping("/book/entrust")
    @ApiOperation("도서 위탁")
    fun entrustBook(@RequestBody entrustDto: EntrustDto): ResponseDto {
        bookEntrustService.entrustBook(entrustDto)
        return ResponseDto(MessageCode.SUCCESS_ENTRUST.message)
    }

}
