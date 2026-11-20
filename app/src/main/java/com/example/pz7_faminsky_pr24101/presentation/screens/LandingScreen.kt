package com.example.pz7_faminsky_pr24101.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingScreen(navController: NavController) {
    // Состояние: открыто ли меню
    var isMenuOpen by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("FITPULSE") },
                navigationIcon = {
                    IconButton(onClick = { isMenuOpen = !isMenuOpen }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Меню")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Добро пожаловать в FITPULSE!",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        // Боковое меню (пока просто заглушка)
        if (isMenuOpen) {
            ModalNavigationDrawer(
                drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
                gesturesEnabled = true,
                drawerContent = {
                    ModalDrawerSheet {
                        Text(
                            text = "Меню",
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.headlineSmall
                        )
                        HorizontalDivider()
                        NavigationDrawerItem(
                            label = { Text("Профиль") },
                            selected = false,
                            onClick = { isMenuOpen = false }
                        )
                        NavigationDrawerItem(
                            label = { Text("Настройки") },
                            selected = false,
                            onClick = { isMenuOpen = false }
                        )
                        NavigationDrawerItem(
                            label = { Text("Выход") },
                            selected = false,
                            onClick = {
                                isMenuOpen = false
                                navController.navigate("login")
                            }
                        )
                        NavigationDrawerItem(
                            label = { Text("Центральная кнопка") },
                            selected = false,
                            onClick = {
                                isMenuOpen = false
                                navController.navigate("schedule")
                            }
                        )
                    }
                }
            ) {
                // Основное содержимое (пустое, чтобы меню работало)
            }
        }
    }
}