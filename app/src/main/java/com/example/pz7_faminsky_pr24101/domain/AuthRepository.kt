package com.example.pz7_faminsky_pr24101.domain.repository

interface AuthRepository {
    suspend fun register(email: String, password: String): Result<Unit>
    suspend fun login(email: String, password: String): Result<Unit>
}