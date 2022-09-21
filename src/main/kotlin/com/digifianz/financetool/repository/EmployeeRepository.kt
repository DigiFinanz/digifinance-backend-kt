package com.digifianz.financetool.repository

import com.digifianz.financetool.entity.EmployeeEntity
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.repository.CrudRepository

interface EmployeeRepository : CrudRepository<EmployeeEntity, Long>

// TEMPORARY, JUST FOR TESTING PURPOSES
@Configuration
class EmployeeStartingData() {
    @Bean
    fun employeeInitializer(employeeRepository: EmployeeRepository) = ApplicationRunner {
        employeeRepository.save(EmployeeEntity(name = "Carlitos"))
        employeeRepository.save(EmployeeEntity(name = "Marquitos"))
        employeeRepository.save(EmployeeEntity(name = "Juan Pablito"))
        employeeRepository.save(EmployeeEntity(name = "Martincito"))
        employeeRepository.save(EmployeeEntity(name = "Elias"))
    }
}