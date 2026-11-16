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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PZ7_Faminsky_PR24101Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "splash"
                    ) {
                        composable("splash") {
                            SplashScreen(navController)
                        }
                        composable("onboarding") {
                            OnboardingScreen()
                        }
                    }
                }
            }
        }
    }
}