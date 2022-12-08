package com.fatih.samplekotlinspringboot.dto


data class InstructorDto(
    val id: Long,
    val name: String,
    val courseList: List<CourseDto>
)
