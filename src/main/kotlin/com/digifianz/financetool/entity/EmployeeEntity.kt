package com.digifianz.financetool.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity(name = "employee")
class EmployeeEntity(
    var name: String,

    @ManyToOne var team: TeamEntity,

    @Id @GeneratedValue var id: Long? = null
)