package org.example.project.commonUI.Auth.login

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import loginscreentest.composeapp.generated.resources.Res
import org.example.project.data.models.LoginRequest
import org.example.project.data.models.RegisterDto
import org.example.project.domain.repositories.AuthRepository

interface LoginView {
    fun login()
}

data class LoginUIState(
    val usernameState: TextFieldState = TextFieldState(),
    val passwordState: TextFieldState = TextFieldState()
)

class LoginViewModel(
    private val authRepository: AuthRepository
): ViewModel(), LoginView{

    var loginUIState by mutableStateOf(LoginUIState())
        private set

    init {
        println("LoginViewModel initialized")
    }

    override fun onCleared() {
        super.onCleared()
        println("LoginViewModel cleared")
    }

    override fun login() {


        val loginRequest = LoginRequest(
            loginUIState.usernameState.text.toString(),
            loginUIState.passwordState.text.toString()
        )

        viewModelScope.launch {
            authRepository.login(loginRequest)
        }


    }

}