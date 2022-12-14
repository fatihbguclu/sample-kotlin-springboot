package com.fatih.samplekotlinspringboot.service

import com.fatih.samplekotlinspringboot.dto.CourseDto
import com.fatih.samplekotlinspringboot.dto.InstructorDto
import com.fatih.samplekotlinspringboot.model.Instructor
import com.fatih.samplekotlinspringboot.repository.InstructorRepository
import org.springframework.stereotype.Service

@Service
class InstructorService(val instructorRepository: InstructorRepository) {

    fun getAllInstructor(): List<InstructorDto> {
        val allInstructor = instructorRepository.findAll()

        val instructorDtoList = allInstructor.map { it ->

            val list = it.courses.map {
                CourseDto(it.id, it.name, it.instructor.id)
            }
            InstructorDto(it.id!!, it.name, list)
        }

        return instructorDtoList
    }

    fun addInstructor(instructorDto: InstructorDto): InstructorDto {
        val instructor : Instructor = instructorDto.let {
            Instructor(id = null, name = it.name)
        }
        instructorRepository.save(instructor)

        return instructor.let {
            val courseDtoList = it.courses.map {
                CourseDto(it.id, it.name, it.instructor.id)
            }

            InstructorDto(it.id!!, it.name, courseDtoList)
        }
    }

}
