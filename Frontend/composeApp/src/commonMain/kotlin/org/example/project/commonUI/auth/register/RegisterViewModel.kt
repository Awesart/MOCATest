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
import org.example.project.domain.errorHandling.DataError
import org.example.project.domain.errorHandling.Result

interface RegisterView {
    fun register(signUpClick: () -> Unit)
}

data class RegisterUiState(
    val usernameState: TextFieldState = TextFieldState(),
    val passwordState: TextFieldState = TextFieldState(),
    val emailState: TextFieldState = TextFieldState(),
    val errorMessage: String = ""
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
        signUpClick: () -> Unit
    ){

        val registerDto= RegisterDto(
            registerUiState.usernameState.text.toString(),
            registerUiState.passwordState.text.toString(),
            registerUiState.emailState.text.toString()
        )

        viewModelScope.launch {
            val result = authRepository.register(registerDto)

            val notAuthResult = Result.Error<Unit, DataError>(DataError.Network.NOT_AUTHORIZED)

            when(result){
                is Result.Success -> signUpClick()
                notAuthResult -> updateErrorMessage("Not Authorized to Register")
                else -> updateErrorMessage("Internal Server Error")
            }

        }

    }

    fun updateErrorMessage(errorMessage: String){
        registerUiState = registerUiState.copy(
            errorMessage = errorMessage
        )
    }


}