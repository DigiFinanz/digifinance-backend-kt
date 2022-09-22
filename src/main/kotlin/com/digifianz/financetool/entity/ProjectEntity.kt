package com.digifianz.financetool.entity

import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity(name = "project")
class ProjectEntity(
    var name: String,
    @ManyToOne var client: ClientEntity,
) : DatabaseEntity()