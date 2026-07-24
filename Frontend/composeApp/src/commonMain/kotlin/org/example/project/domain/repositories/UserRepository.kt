package org.example.project.domain.repositories

import kotlinx.coroutines.flow.Flow
import org.example.project.data.network.UserSessionNetworkApi
import org.example.project.database.UserSession
import org.example.project.database.UserDataStore


interface UserRepository{
    val userSession: Flow<UserSession>

    suspend fun setUserToken(jwtToken: String)

    suspend fun getUser(userSession: UserSession?)
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

    override suspend fun getUser(userSession: UserSession?) {
        userSessionNetworkApi.getUser(userSession)
    }

}
