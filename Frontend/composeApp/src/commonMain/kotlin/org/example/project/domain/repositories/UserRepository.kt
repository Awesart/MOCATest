package org.example.project.domain.repositories

import kotlinx.coroutines.flow.Flow
import org.example.project.data.network.UserSessionNetworkApi
import org.example.project.database.UserSession
import org.example.project.database.UserDataStore
import org.example.project.domain.errorHandling.fold


interface UserRepository{
    val userSession: Flow<UserSession>

    suspend fun setUserToken(jwtToken: String)

    suspend fun getUser(userSession: UserSession?): String
}

class UserRepositoryImpl (
    private val userDataStore: UserDataStore,
    private val userSessionNetworkApi: UserSessionNetworkApi
): UserRepository{

    override val userSession: Flow<UserSession>
        get() = userDataStore.userSession

    override suspend fun setUserToken(jwtToken: String) {
        userDataStore.updateUser(jwtToken)
    }

    override suspend fun getUser(userSession: UserSession?): String {
        val result = userSessionNetworkApi.getUser(userSession)
        return result.fold(
            onSuccess = { user ->
                user.username
            },
            onFailure = { error ->
                error.toString()
            }
        )
    }

}
