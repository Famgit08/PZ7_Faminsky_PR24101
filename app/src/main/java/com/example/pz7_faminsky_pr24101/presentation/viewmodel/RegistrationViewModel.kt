package com.example.pz7_faminsky_pr24101.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pz7_faminsky_pr24101.data.repository.AuthRepositoryImpl
import com.example.pz7_faminsky_pr24101.domain.repository.AuthRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class RegistrationViewModel : ViewModel() {
    private val repository: AuthRepository = AuthRepositoryImpl()

    var isLoading by androidx.compose.runtime.mutableStateOf(false)
    var errorMessage by androidx.compose.runtime.mutableStateOf<String?>(null)

    fun register(email: String, password: String, onSuccess: () -> Unit) {
        isLoading = true
        errorMessage = null
        viewModelScope.launch {
            val result = repository.register(email, password)
            isLoading = false
            result.onSuccess { onSuccess() }
                .onFailure { errorMessage = it.message }
        }
    }
}