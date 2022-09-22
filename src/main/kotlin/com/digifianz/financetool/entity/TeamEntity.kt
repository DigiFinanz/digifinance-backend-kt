package com.digifianz.financetool.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "team")
class TeamEntity(
    var name: String,

    @Id @GeneratedValue var id: Long? = null
)