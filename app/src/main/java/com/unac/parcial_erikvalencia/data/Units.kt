package com.unac.parcial_erikvalencia.data

import com.unac.parcial_erikvalencia.domain.UnitOption


val lengthUnits = listOf(
    UnitOption("Centímetros", { it / 100}, { it * 100}),
    UnitOption("Metros", { it }, { it }),
    UnitOption("Kilómetros", { it * 1000 }, { it / 1000 }),
    UnitOption("Pulgadas", { it * 0.0254 }, { it / 0.0254 }),
)

val massUnits = listOf(
    UnitOption("Toneladas", { it * 1000 }, { it / 1000 }),
    UnitOption("Kilogramos", { it }, { it }),
    UnitOption("Libras", { it / 0.453592 }, { it * 0.453592 }),
    UnitOption("Gramos", { it / 1000 }, { it * 1000 })
)
val temperatureUnits = listOf(

    UnitOption(name = "Celsius (°C)", toBase = { it }, fromBase = { it }),
    UnitOption(name = "Fahrenheit (°F)", toBase = { (it - 32) * 5 / 9 }, fromBase = { (it * 9 / 5) + 32 }),
    UnitOption(name = "Kelvin (K)", toBase = { it - 273.15 }, fromBase = { it + 273.15 }),
    UnitOption(name = "Rankine (°R)", toBase = { (it - 491.67) * 5 / 9 }, fromBase = { (it * 9 / 5) + 491.67 })
)