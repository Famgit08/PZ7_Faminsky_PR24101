package com.example.pz7_faminsky_pr24101.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun OnboardingScreen(navController: NavController) {
    // Состояние: текущая страница (0, 1, 2)
    var currentPage by remember { mutableIntStateOf(0) }

    val page = onboardingPages[currentPage]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Картинка
        Image(
            painter = painterResource(id = page.imageRes),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Заголовок
        Text(
            text = page.title,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Описание
        Text(
            text = page.description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(48.dp))

        // Кнопка "Далее" или "Начать"
        Button(
            onClick = {
                if (currentPage < onboardingPages.size - 1) {
                    currentPage++
                } else {
                    // Последний экран — переход на регистрацию
                    navController.navigate("registration")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (currentPage < onboardingPages.size - 1) "Далее" else "Начать")
        }

        // Кнопка "Пропустить"
        TextButton(
            onClick = {
                navController.navigate("registration")
            }
        ) {
            Text("Пропустить")
        }
    }
}