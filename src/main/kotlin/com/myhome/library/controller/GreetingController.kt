package com.myhome.library.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
@Api(tags = ["Greeting 컨트롤러 테스트"])
class GreetingController {

    @GetMapping("/greeting")
    @ApiOperation(value = "그리팅 테스트 컨트롤러")
    fun greeting(string: String): String {
        return "Greeting $string"
    }
}
