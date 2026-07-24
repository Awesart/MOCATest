package org.example.project.data.network

import androidx.lifecycle.viewModelScope
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpHeaders
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.example.project.data.models.JWTRequest
import org.example.project.data.models.UserUiDto
import org.example.project.database.UserSession
import org.example.project.domain.errorHandling.DataError
import org.example.project.domain.errorHandling.Error
import org.example.project.domain.errorHandling.Result
import org.example.project.domain.repositories.UserRepository

interface UserApi{
    suspend fun getUser(userSession: UserSession): Result<Unit, DataError>
}

class UserSessionNetworkApi (
    private val client: HttpClient
): UserApi{

    override suspend fun getUser(
        userSession: UserSession
    ): Result<Unit, DataError> {
        val connectionString: String = "user/ui"

        return try{
            val response: HttpResponse = client.get(connectionString){
                headers{
                    append(HttpHeaders.Authorization, userSession.token)
                }
            }

            if (response.status.value in 200..299) {

                val userUiDto: UserUiDto = response.body()

                println(userUiDto)

                Result.Success(Unit)
            }
            else{
                when(response.status.value){
                    401 -> Result.Error(DataError.Network.NOT_AUTHORIZED)
                    403 -> Result.Error(DataError.Network.FORBIDDEN)
                    404 -> Result.Error(DataError.Network.NOT_FOUND)
                    408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
                    413 -> Result.Error(DataError.Network.PAYLOAD_TOO_LARGE)
                    429 -> Result.Error(DataError.Network.TOO_MANY_REQUESTS)
                    else -> Result.Error(DataError.Network.UNKNOWN)
                }
            }
        }
        catch (e: Exception){
            println("Exception is ${e.message}")
            Result.Error(DataError.Local.HTTP_CLIENT_ISSUE)
        }



    }
}