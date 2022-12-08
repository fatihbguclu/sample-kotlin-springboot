package com.fatih.samplekotlinspringboot.controller

import com.fatih.samplekotlinspringboot.service.GreetingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("greeting")
class GreetingController(val greetingService: GreetingService) {

    @GetMapping("/{name}")
    fun sayHello(@PathVariable name: String): String {
        return greetingService.sayHello(name)
    }

}