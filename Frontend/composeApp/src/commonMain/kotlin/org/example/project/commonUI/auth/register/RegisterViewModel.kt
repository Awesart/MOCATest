package org.example.project.commonUI.auth.viewModels

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.project.domain.repositories.AuthRepository
import org.example.project.data.models.RegisterDto

interface RegisterView {
    fun register()
}

data class RegisterUiState(
    val usernameState: TextFieldState = TextFieldState(),
    val passwordState: TextFieldState = TextFieldState(),
    val emailState: TextFieldState = TextFieldState()
)

class RegisterViewModel(
    private val authRepository: AuthRepository
): ViewModel(), RegisterView {

    //Ensures that external classes cannot modify the state.
    //State can only be modified through the viewModel
    var registerUiState by mutableStateOf(RegisterUiState())
        private set

    init {
        println("RegisterViewModel initialized")
    }

    override fun onCleared() {
        super.onCleared()
        println("RegisterViewModel cleared")
    }


    override fun register(
    ){

        val registerDto: RegisterDto = RegisterDto(
            registerUiState.usernameState.text.toString(),
            registerUiState.passwordState.text.toString(),
            registerUiState.emailState.text.toString()
        )

        viewModelScope.launch {
            authRepository.register(registerDto)

        }

    }


}