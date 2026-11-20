package com.example.pz7_faminsky_pr24101.data.repository

import com.example.pz7_faminsky_pr24101.domain.repository.AuthRepository
import kotlinx.coroutines.delay

class AuthRepositoryImpl : AuthRepository {
    override suspend fun register(email: String, password: String): Result<Unit> {
        delay(1000L) // Имитация запроса
        return if (email.isNotEmpty() && password.isNotEmpty()) {
            Result.success(Unit)
        } else {
            Result.failure(Exception("Ошибка регистрации: пустые поля"))
        }
    }

    override suspend fun login(email: String, password: String): Result<Unit> {
        delay(1000L) // Имитация запроса
        return if (email.isNotEmpty() && password.isNotEmpty()) {
            Result.success(Unit)
        } else {
            Result.failure(Exception("Ошибка входа: пустые поля"))
        }
    }
}