package com.digifianz.financetool.entity

abstract class ModelEntity<T> {
    abstract fun toModel(): T
}