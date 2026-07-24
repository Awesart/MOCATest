package org.example.project.commonUI.mainContent.mainHome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.example.project.database.UserSession
import org.example.project.domain.repositories.UserRepository

interface MainHomeView{
    fun getUser()
}

class MainHomeViewModel(
    private val userRepository: UserRepository
) : ViewModel(), MainHomeView{

    val userSession: StateFlow<UserSession?> = userRepository.userSession
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = null
        )

    init {
        println("MainHomeViewModel initialized")
        getUser()
    }

    override fun onCleared() {
        super.onCleared()
        println("MainHomeViewModel cleared")
    }

    override fun getUser(){

        viewModelScope.launch {
            userRepository.getUser(userSession.value)
        }

    }

}