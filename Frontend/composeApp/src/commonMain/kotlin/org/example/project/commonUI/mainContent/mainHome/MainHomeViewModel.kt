package org.example.project.commonUI.mainContent.mainHome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.database.UserSession
import org.example.project.domain.repositories.UserRepository

interface MainHomeView{
    fun getUser(userSession: UserSession?)
}

data class MainHomeUiState(
    val username: String = ""
)

class MainHomeViewModel(
    private val userRepository: UserRepository
) : ViewModel(), MainHomeView{

    private val _uiState = MutableStateFlow(MainHomeUiState())
    val uiState: StateFlow<MainHomeUiState> = _uiState.asStateFlow()

    val userSession: StateFlow<UserSession?> = userRepository.userSession
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    init {
        println("MainHomeViewModel initialized")
    }

    override fun onCleared() {
        super.onCleared()
        println("MainHomeViewModel cleared")
    }

    override fun getUser(userSession: UserSession?){

        viewModelScope.launch {
            val username = userRepository.getUser(userSession)
            _uiState.update { currentState ->
                currentState.copy(
                    username = username
                )
            }
        }

    }

}