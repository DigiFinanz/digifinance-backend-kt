package com.digifianz.financetool.entity

import javax.persistence.Entity

@Entity(name = "client")
class ClientEntity(var name: String) : DatabaseEntity()