package org.example.project.commonUI.auth.viewModels

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
    val username: String = "",
    val password: String = "",
    val email: String = ""
)

class RegisterViewModel(
    private val authRepository: AuthRepository
): ViewModel(), RegisterView {

    //Ensures that external classes cannot modify the state.
    //State can only be modified through the viewModel
    var registerUiState by mutableStateOf(RegisterUiState())
        private set

    fun updateUsername(input: String){
        registerUiState = registerUiState.copy(
            username = input
        )
    }

    fun updatePassword(input: String){
        registerUiState = registerUiState.copy(
            password = input
        )
    }

    fun updateEmail(input: String){
        registerUiState = registerUiState.copy(
            email = input
        )
    }

    override fun register(
    ){

        val registerDto: RegisterDto = RegisterDto(
            registerUiState.username,
            registerUiState.password,
            registerUiState.email
        )

        viewModelScope.launch {
            authRepository.register(registerDto)

        }

    }


}