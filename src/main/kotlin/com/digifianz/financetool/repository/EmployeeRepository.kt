package com.digifianz.financetool.repository

import com.digifianz.financetool.entity.EmployeeEntity
import org.springframework.data.repository.CrudRepository

interface EmployeeRepository : CrudRepository<EmployeeEntity, Long>