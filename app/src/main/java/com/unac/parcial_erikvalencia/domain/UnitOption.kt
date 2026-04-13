package com.unac.parcial_erikvalencia.domain

data class UnitOption(
    val name: String,
    val toBase: (Double) -> Double,
    val fromBase: (Double) -> Double
)
