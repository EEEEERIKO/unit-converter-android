package com.unac.parcial_erikvalencia.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.unac.parcial_erikvalencia.domain.UnitOption
import com.unac.parcial_erikvalencia.domain.convert
@Composable
fun ConverterTab(
    title: String,
    units: List<UnitOption>
) {
    var inputVal by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    var fromUnit by remember { mutableStateOf(units[0]) }
    var toUnit by remember { mutableStateOf(units[1]) }

    Column(Modifier.padding(16.dp)) {

        Text(title, style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = inputVal,
            onValueChange = { inputVal = it },
            label = { Text("Valor") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        UnitDropdown(
            label = "De",
            selected = fromUnit,
            options = units,
            onSelectedChange = { fromUnit = it }
        )

        UnitDropdown(
            label = "A",
            selected = toUnit,
            options = units,
            onSelectedChange = { toUnit = it }
        )

        Button(
            onClick = {
                val temp = fromUnit
                fromUnit = toUnit
                toUnit = temp
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Invertir")
        }

        Button(
            onClick = {
                val value = inputVal.toDoubleOrNull()
                if (value != null) {
                    val converted = convert(value, fromUnit, toUnit)
                    result = "%.2f %s = %.2f %s".format(
                        value,
                        fromUnit.name,
                        converted,
                        toUnit.name
                    )
                } else {
                    result = "Valor inválido"
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Convertir")
        }

        Text(result, modifier = Modifier.padding(top = 16.dp))
    }
}