package com.digifianz.financetool

import com.digifianz.financetool.repository.EmployeeRepository
import com.digifianz.financetool.repository.TeamRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
class DigiFinanceApplication

fun main(args: Array<String>) {
    runApplication<DigiFinanceApplication>(*args)
}


// TEMPORARY, JUST FOR TESTING PURPOSES
@Configuration
class EmployeeStartingData {
    @Bean
    fun employeeInitializer(employeeRepository: EmployeeRepository, teamRepository: TeamRepository) =
        ApplicationRunner {
            /*val team = teamRepository.save(TeamEntity(name = "Customer Success 1"))

            employeeRepository.save(EmployeeEntity(name = "Carlitos", team = team))
            employeeRepository.save(EmployeeEntity(name = "Marquitos", team = team))
            employeeRepository.save(EmployeeEntity(name = "Juan Pablito", team = team))
            employeeRepository.save(EmployeeEntity(name = "Martincito", team = team))
            employeeRepository.save(EmployeeEntity(name = "Elias", team = team))*/
        }
}