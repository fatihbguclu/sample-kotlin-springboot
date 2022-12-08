package com.fatih.samplekotlinspringboot.service

import org.springframework.stereotype.Service

@Service
class GreetingService {

    fun sayHello(name: String): String {
        return "Hello $name"
    }

}
