package com.digifianz.financetool.entity

import com.digifianz.financetool.model.Employee
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class EmployeeEntity(
    var name: String,
    @Id @GeneratedValue var id: Long? = null,
) : ModelEntity<Employee>() {

    override fun toModel() = Employee(
        name = name
    )
}