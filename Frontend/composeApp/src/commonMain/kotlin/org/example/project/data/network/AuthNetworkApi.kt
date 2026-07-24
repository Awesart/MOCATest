package org.example.project.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.example.project.data.models.JWTRequest
import org.example.project.domain.errorHandling.DataError
import org.example.project.domain.errorHandling.Result
import org.example.project.data.models.LoginRequest
import org.example.project.data.models.RegisterDto
import org.example.project.data.models.UserUiDto
import org.example.project.domain.repositories.UserRepository

interface AuthApi{
    suspend fun login(loginRequest: LoginRequest): Result<Unit, DataError>
    suspend fun register(registerDto: RegisterDto): Result<String, DataError>
}

class AuthNetworkApi(
    private val client: HttpClient,
    private val userRepository: UserRepository
): AuthApi {

    override suspend fun login(
        loginRequest: LoginRequest
    ): Result<Unit, DataError>{
        val connectionString = "auth/login"

        return try{
            val response: HttpResponse = client.post(connectionString){
                contentType(ContentType.Application.Json)
                setBody(loginRequest)
            }

            if (response.status.value in 200..299) {

                val tokenObject: JWTRequest = response.body()

                val token = tokenObject.accessToken

                println(token)

                userRepository.setUserToken(token)

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
        catch(e: Exception){
            println("Exception is ${e.message}")
            Result.Error(DataError.Local.HTTP_CLIENT_ISSUE)
        }



    }

    override suspend fun register(
        registerDto: RegisterDto
    ): Result<String, DataError>{

        val connectionEndpoint = "auth/register"

        return try {
            val response: HttpResponse = client.post(connectionEndpoint){
                contentType(ContentType.Application.Json)
                setBody(registerDto)
            }

            if (response.status.value in 200..299) {
                Result.Success("Response was successful")
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
        catch(e: Exception){
            println("Exception is ${e.message}")
            Result.Error(DataError.Local.HTTP_CLIENT_ISSUE)
        }


    }

}