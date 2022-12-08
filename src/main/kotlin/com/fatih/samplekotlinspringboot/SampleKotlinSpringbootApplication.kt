package com.fatih.samplekotlinspringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SampleKotlinSpringbootApplication

fun main(args: Array<String>) {
    runApplication<SampleKotlinSpringbootApplication>(*args)
}
