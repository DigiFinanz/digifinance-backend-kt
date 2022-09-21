package com.digifianz.financetool.controller

import com.digifianz.financetool.model.Employee
import com.digifianz.financetool.repository.EmployeeRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/employee")
class EmployeeController(private val repository: EmployeeRepository) {

    @GetMapping("/")
    fun getAll(): List<Employee> = repository.findAll().map { it.toModel() }.toList()
}