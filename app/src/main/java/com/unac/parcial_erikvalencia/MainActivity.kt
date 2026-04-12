package com.unac.parcial_erikvalencia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unac.parcial_erikvalencia.ui.theme.ParcialErikValenciaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ParcialErikValenciaTheme {
                AppNavigation()
            }
        }
    }
}

enum class Screens { Registro, Conversora }

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.Registro.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screens.Registro.name) {
                RegistroScreen(onRegisterSuccess = { navController.navigate(Screens.Conversora.name) })
            }
            composable(Screens.Conversora.name) {
                ConversoraScreen()
            }
        }
    }
}

@Composable
fun RegistroScreen(onRegisterSuccess: () -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Registro de Usuario", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = onRegisterSuccess, modifier = Modifier.padding(top = 16.dp)) {
            Text("Registrarse")
        }
    }
}

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
            0 -> LongitudTab()
            1 -> MasaTab()
            2 -> TemperaturaTab()
        }
    }
}

@Composable
fun LongitudTab() {
    var inputVal by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        Text("Centímetros a Pulgadas", style = MaterialTheme.typography.titleMedium)
        OutlinedTextField(
            value = inputVal,
            onValueChange = { inputVal = it },
            label = { Text("Valor en CM") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            val cm = inputVal.toDoubleOrNull() ?: 0.0
            val inches = cm / 2.54
            result = "Resultado: %.2f Pulgadas".format(inches)
        }, modifier = Modifier.padding(top = 8.dp)) {
            Text("Convertir")
        }
        Text(result, modifier = Modifier.padding(top = 16.dp))
    }
}

@Composable
fun MasaTab() {
    var inputVal by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        Text("Kilogramos a Libras", style = MaterialTheme.typography.titleMedium)
        OutlinedTextField(
            value = inputVal,
            onValueChange = { inputVal = it },
            label = { Text("Valor en KG") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            val kg = inputVal.toDoubleOrNull() ?: 0.0
            val lbs = kg * 2.20462
            result = "Resultado: %.2f Libras".format(lbs)
        }, modifier = Modifier.padding(top = 8.dp)) {
            Text("Convertir")
        }
        Text(result, modifier = Modifier.padding(top = 16.dp))
    }
}

@Composable
fun TemperaturaTab() {
    var inputVal by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        Text("Celsius a Fahrenheit", style = MaterialTheme.typography.titleMedium)
        OutlinedTextField(
            value = inputVal,
            onValueChange = { inputVal = it },
            label = { Text("Valor en °C") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            val celsius = inputVal.toDoubleOrNull() ?: 0.0
            val fahrenheit = (celsius * 9 / 5) + 32
            result = "Resultado: %.2f °F".format(fahrenheit)
        }, modifier = Modifier.padding(top = 8.dp)) {
            Text("Convertir")
        }
        Text(result, modifier = Modifier.padding(top = 16.dp))
    }
}
