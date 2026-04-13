package com.unac.parcial_erikvalencia.domain

fun convert(value: Double, from: UnitOption, to: UnitOption): Double {
    val baseValue = from.toBase(value)
    return  to.fromBase(baseValue)

}