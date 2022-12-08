package com.fatih.samplekotlinspringboot.repository

import com.fatih.samplekotlinspringboot.model.Course
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : CrudRepository<Course,Long> {

}