package com.example.pz7_faminsky_pr24101

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pz7_faminsky_pr24101.presentation.screens.OnboardingScreen
import com.example.pz7_faminsky_pr24101.presentation.screens.SplashScreen
import com.example.pz7_faminsky_pr24101.presentation.theme.PZ7_Faminsky_PR24101Theme
import com.example.pz7_faminsky_pr24101.presentation.screens.RegistrationScreen
import com.example.pz7_faminsky_pr24101.presentation.screens.LoginScreen
import com.example.pz7_faminsky_pr24101.presentation.screens.LandingScreen
import com.example.pz7_faminsky_pr24101.presentation.screens.ScheduleGameScreen
import com.example.pz7_faminsky_pr24101.presentation.screens.SuccessScreen
import com.example.pz7_faminsky_pr24101.presentation.screens.LegalScreen
import androidx.compose.runtime.LaunchedEffect

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPrefs = getSharedPreferences("app_prefs", MODE_PRIVATE)

        setContent {
            PZ7_Faminsky_PR24101Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    val lastScreen = sharedPrefs.getString("last_screen", "splash") ?: "splash"
                    NavHost(
                        navController = navController,
                        startDestination = lastScreen

                    ) {
                        composable("splash") {
                            SplashScreen(navController)
                        }
                        composable("onboarding") {
                            OnboardingScreen(navController)
                        }
                        composable("registration") {
                            RegistrationScreen(navController)
                        }
                        composable("login") {
                            LoginScreen(navController)
                        }
                        composable("landing") {
                            LandingScreen(navController)
                        }
                        composable("schedule") {
                            ScheduleGameScreen(navController)
                        }
                        composable("success") {
                            SuccessScreen(navController)
                        }
                        composable("schedule") {
                            ScheduleGameScreen(navController)
                        }
                        composable("success") {
                            SuccessScreen(navController)
                        }
                        composable("legal") {
                            LegalScreen(navController)
                        }
                    }
                    LaunchedEffect(navController) {
                        navController.addOnDestinationChangedListener { _, destination, _ ->
                            sharedPrefs.edit().putString("last_screen", destination.route).apply()
                        }
                    }
                }
            }
        }
    }
}