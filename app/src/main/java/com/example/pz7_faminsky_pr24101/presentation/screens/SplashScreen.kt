package com.example.pz7_faminsky_pr24101.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pz7_faminsky_pr24101.R
import kotlinx.coroutines.delay
import androidx.compose.ui.tooling.preview.Preview
import com.example.pz7_faminsky_pr24101.presentation.theme.PZ7_Faminsky_PR24101Theme

@Composable
fun SplashScreen(navController: NavController) {
    // Задержка 2 секунды и переход на экран приветствия
    LaunchedEffect(key1 = true) {
        delay(2000L)
        navController.navigate("onboarding") {
            popUpTo("splash") { inclusive = true }
        }
    }

    // Дизайн: тёмный фон и логотип по центру
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Логотип FITPULSE",
            modifier = Modifier.size(150.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    PZ7_Faminsky_PR24101Theme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Логотип",
                modifier = Modifier.size(150.dp)
            )
        }
    }
}