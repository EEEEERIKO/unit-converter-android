package com.unac.parcial_erikvalencia.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.unac.parcial_erikvalencia.data.lengthUnits
import com.unac.parcial_erikvalencia.data.massUnits
import com.unac.parcial_erikvalencia.data.temperatureUnits
import com.unac.parcial_erikvalencia.ui.components.ConverterTab


@Composable
fun ConversoraScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Longitud", "Masa", "Temperatura")

    Column {
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) })
            }
        }
        when (selectedTab) {
            0 -> ConverterTab("Conversor de Longitud", lengthUnits)
            1 -> ConverterTab("Conversor de Masa", massUnits)
            2 -> ConverterTab("Conversor de Temperatura", temperatureUnits)
        }
    }
}
