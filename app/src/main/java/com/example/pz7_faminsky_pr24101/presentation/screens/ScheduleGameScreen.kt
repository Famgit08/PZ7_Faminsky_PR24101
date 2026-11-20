package com.example.pz7_faminsky_pr24101.presentation.screens

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleGameScreen(navController: NavController) {
    val context = LocalContext.current
    var gameName by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("Выберите дату") }
    var selectedTime by remember { mutableStateOf("Выберите время") }

    val calendar = Calendar.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Schedule Game",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = gameName,
            onValueChange = { gameName = it },
            label = { Text("Название игры") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = {
                DatePickerDialog(
                    context,
                    { _, year, month, day ->
                        selectedDate = "$day.${month + 1}.$year"
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(selectedDate)
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = {
                TimePickerDialog(
                    context,
                    { _, hour, minute ->
                        selectedTime = String.format("%02d:%02d", hour, minute)
                    },
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    true
                ).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(selectedTime)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                if (gameName.isNotEmpty() && selectedDate != "Выберите дату" && selectedTime != "Выберите время") {
                    navController.navigate("success")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Publish")
        }
    }
}