package com.digifianz.financetool.entity

import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity(name = "team")
class TeamEntity(
    var name: String,
    @OneToMany var projects: MutableList<ProjectEntity> = mutableListOf(),
) : DatabaseEntity() {


}