package com.digifianz.financetool.util

const val DOLLAR_PRICE = 205

@JvmInline
value class Ars(val ars: Double) {
    val usd get() = ars / DOLLAR_PRICE
    fun toUsd() = Usd(usd)
}

@JvmInline
value class Usd(val usd: Double) {
    val ars get() = usd * DOLLAR_PRICE
    fun toArs() = Ars(ars)
}

@JvmInline
value class Percentage(val percent: Double) {
    val decimal get() = percent / 100.0
}


val Number.ars get() = Ars(this.toDouble())
val Number.usd get() = Usd(this.toDouble())
val Number.percent get() = Percentage(this.toDouble())
fun Double.decimalToPercentage() = Percentage(this * 100.0)