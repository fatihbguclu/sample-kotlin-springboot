package com.fatih.samplekotlinspringboot.repository

import com.fatih.samplekotlinspringboot.model.Instructor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InstructorRepository : CrudRepository<Instructor,Long> {

}