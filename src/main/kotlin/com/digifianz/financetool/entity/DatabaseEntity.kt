package com.digifianz.financetool.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
abstract class DatabaseEntity {
    @Id
    @GeneratedValue
    var id: Long? = null
}