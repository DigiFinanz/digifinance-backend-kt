package com.digifianz.financetool.repository

import com.digifianz.financetool.entity.TeamEntity
import org.springframework.data.repository.CrudRepository

interface TeamRepository : CrudRepository<TeamEntity, Long>