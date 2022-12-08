package com.fatih.samplekotlinspringboot.service

import com.fatih.samplekotlinspringboot.dto.CourseDto
import com.fatih.samplekotlinspringboot.model.Course
import com.fatih.samplekotlinspringboot.repository.CourseRepository
import com.fatih.samplekotlinspringboot.repository.InstructorRepository
import mu.KLogging
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CourseService(val courseRepository: CourseRepository,
                    val instructorRepository: InstructorRepository) {

    companion object: KLogging()

    fun addCourse(courseDto: CourseDto): CourseDto {

        val instructor = instructorRepository.findById(courseDto.id!!)

        if (instructor.isEmpty){
            throw RuntimeException("Instructor doesn't exist")// TODO Custom Exception
        }

        val course = Course(null, courseDto.name, instructor.get())

        val savedCourse = courseRepository.save(course)

        logger.info("Saved Course = $savedCourse")

        return savedCourse.let {
            CourseDto(it.id, it.name,it.instructor.id)
        }

    }

    fun getAllCourses(): List<CourseDto> {

        val courses = courseRepository.findAll()

        return courses.map {
            CourseDto(it.id, it.name, it.instructor.id)
        }
    }

    fun updateCourse(courseDto: CourseDto, courseId: Long): CourseDto {

        val course = courseRepository.findById(courseId)

        return if (course.isPresent){
            course.get().let {
                it.name = courseDto.name
                it.instructor = instructorRepository.findById(courseDto.instructorId!!).get()
                courseRepository.save(it)
                CourseDto(it.id, it.name, it.instructor.id)
            }
        }else{
            throw RuntimeException("error")// TODO Custom Exception
        }
    }

    fun deleteCourse(courseId: Long) {
        val course = courseRepository.findById(courseId)

        if (course.isPresent){
            course.get().let {
                    courseRepository.delete(it)
                }
        }else{
            throw RuntimeException("error")// TODO Custom Exception
        }

    }

}
