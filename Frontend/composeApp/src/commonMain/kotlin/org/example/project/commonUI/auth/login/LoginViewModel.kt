package org.example.project.commonUI.auth.login

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.project.data.models.LoginRequest
import org.example.project.domain.errorHandling.DataError
import org.example.project.domain.errorHandling.Result
import org.example.project.domain.repositories.AuthRepository

interface LoginView {
    fun login( onLoginSuccessfulClick: () -> Unit )
}

data class LoginUIState(
    val usernameState: TextFieldState = TextFieldState(),
    val passwordState: TextFieldState = TextFieldState(),
    var errorMessage: String = ""
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

    override fun login(
        onLoginSuccessfulClick: () -> Unit
    ) {

        val loginRequest = LoginRequest(
            loginUIState.usernameState.text.toString(),
            loginUIState.passwordState.text.toString()
        )

        viewModelScope.launch {
            val result = authRepository.login(loginRequest)

            val notAuthResult = Result.Error<Unit, DataError>(DataError.Network.NOT_AUTHORIZED)

            when(result){
                is Result.Success -> onLoginSuccessfulClick()
                notAuthResult -> updateErrorMessage("User is not authorized")
                else -> updateErrorMessage("Internal server error")
            }

        }

    }

    fun updateErrorMessage(errorMessage: String){
        loginUIState = loginUIState.copy(
            errorMessage = errorMessage
        )
    }

}