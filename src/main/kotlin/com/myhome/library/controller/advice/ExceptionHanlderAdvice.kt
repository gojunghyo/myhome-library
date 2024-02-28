package com.myhome.library.controller.advice

import com.myhome.library.dto.member.ResponseDto
import com.myhome.library.utils.logger
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHanlderAdvice {

    private val log = logger()

    @ExceptionHandler(
        IllegalArgumentException::class,
        IllegalStateException::class,
    )
    @ResponseBody
    fun handleIllegalArgumentAndStateException(e: Exception): ResponseDto {
        log.error("Error message = ${e.message}")

        return ResponseDto(e.message)
    }
}
