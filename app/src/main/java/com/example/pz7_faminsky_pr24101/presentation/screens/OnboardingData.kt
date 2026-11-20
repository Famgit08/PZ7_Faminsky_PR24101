package com.example.pz7_faminsky_pr24101.presentation.screens

import androidx.annotation.DrawableRes
import com.example.pz7_faminsky_pr24101.R

data class OnboardingPage(
    val title: String,
    val description: String,
    @DrawableRes val imageRes: Int
)

val onboardingPages = listOf(
    OnboardingPage(
        title = "Добро пожаловать в FITPULSE!",
        description = "Твой персональный помощник для тренировок и здоровья.",
        imageRes = R.drawable.onboarding_1
    ),
    OnboardingPage(
        title = "Следи за прогрессом",
        description = "Отслеживай свои достижения и становись лучше каждый день.",
        imageRes = R.drawable.onboarding_2
    ),
    OnboardingPage(
        title = "Начни прямо сейчас",
        description = "Присоединяйся к сообществу FITPULSE и меняй свою жизнь к лучшему.",
        imageRes = R.drawable.onboarding_3
    )
)