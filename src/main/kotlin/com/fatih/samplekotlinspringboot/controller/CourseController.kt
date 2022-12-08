package com.fatih.samplekotlinspringboot.controller

import com.fatih.samplekotlinspringboot.dto.CourseDto
import com.fatih.samplekotlinspringboot.service.CourseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/courses")
class CourseController(val courseService: CourseService) {


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllCourses(): List<CourseDto>{
        return courseService.getAllCourses()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addCourse(@RequestBody courseDto: CourseDto): CourseDto {
        return courseService.addCourse(courseDto)
    }

    @PutMapping("/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateCourse(@RequestBody courseDto: CourseDto,
                      @PathVariable courseId: Long): CourseDto {
        return courseService.updateCourse(courseDto, courseId)
    }

    @DeleteMapping("/{courseId}")
    fun deleteCourse(@PathVariable courseId: Long): Unit {
        return courseService.deleteCourse(courseId)
    }

}