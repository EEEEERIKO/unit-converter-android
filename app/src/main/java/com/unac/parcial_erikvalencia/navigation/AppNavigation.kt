package com.unac.parcial_erikvalencia.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.unac.parcial_erikvalencia.ui.screens.ConversoraScreen
import com.unac.parcial_erikvalencia.ui.screens.RegistroScreen
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