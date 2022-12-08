package com.fatih.samplekotlinspringboot.controller

import com.fatih.samplekotlinspringboot.dto.InstructorDto
import com.fatih.samplekotlinspringboot.service.InstructorService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/instructors")
class InstructorController(val instructorService: InstructorService) {

    @GetMapping
    fun getAllInstructors(): List<InstructorDto> {
        return instructorService.getAllInstructor()
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    fun addInstructor(): InstructorDto {
        return instructorService.addInstructor()
    }

}