package com.digifianz.financetool

import com.digifianz.financetool.entity.EmployeeEntity
import com.digifianz.financetool.entity.TeamEntity
import com.digifianz.financetool.repository.EmployeeRepository
import com.digifianz.financetool.repository.TeamRepository
import com.digifianz.financetool.util.ars
import com.digifianz.financetool.util.usd
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
            val alpha = teamRepository.save(TeamEntity(name = "CS Team Alpha"))
            val bravo = teamRepository.save(TeamEntity(name = "CS Team Bravo"))

            employeeRepository.save(EmployeeEntity(name = "CS Member A", team = alpha, unionSalary = 1_266.44.usd, hasGSuiteAdditionalStorage = true))
            employeeRepository.save(EmployeeEntity(name = "CS Member B", team = alpha, netSalary = 89_519.ars))
            employeeRepository.save(EmployeeEntity(name = "CS Member C", team = alpha, netSalary = 97_300.ars))
            employeeRepository.save(EmployeeEntity(name = "CS Member E", team = alpha, netSalary = 160_675.ars))
            employeeRepository.save(EmployeeEntity(name = "CS Member F", team = bravo, unionSalary = 955.84.usd, hasGSuiteAdditionalStorage = true))
            employeeRepository.save(EmployeeEntity(name = "CS Member G", team = bravo, netSalary = 86_164.ars, hasGSuiteAdditionalStorage = true))
            employeeRepository.save(EmployeeEntity(name = "CS Member H", team = bravo, netSalary = 93_800.ars, hasGSuiteAdditionalStorage = true))
        }
}