package com.fatih.samplekotlinspringboot.model

import javax.persistence.*

@Entity
@Table(name = "COURSES")
open class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long?,

    var name: String,

    @ManyToOne()
    @JoinColumn(name = "instructor_id")
    var instructor: Instructor
    )
{
}
