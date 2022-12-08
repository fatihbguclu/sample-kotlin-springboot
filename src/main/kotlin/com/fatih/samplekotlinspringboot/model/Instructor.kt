package com.fatih.samplekotlinspringboot.model

import javax.persistence.*

@Entity
@Table(name = "INSTRUCTORS")
open class Instructor(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long?,

    val name : String,

    @OneToMany(
        mappedBy = "instructor"
    )
    val courses : List<Course> = mutableListOf()
    )
{

}
