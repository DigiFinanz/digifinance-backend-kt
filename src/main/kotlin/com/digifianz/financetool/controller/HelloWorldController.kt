package com.digifianz.financetool.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping
    fun index() = "Hello!"

    @GetMapping("/hello")
    fun hello(
        @RequestParam(value = "name", defaultValue = "world") name: String
    ) = "Hello $name!"
}