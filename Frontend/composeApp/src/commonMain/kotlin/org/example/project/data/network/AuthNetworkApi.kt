package org.example.project.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import org.example.project.domain.errorHandling.DataError
import org.example.project.domain.errorHandling.Result
import org.example.project.data.models.LoginRequest
import org.example.project.data.models.RegisterDto
import org.koin.core.annotation.Singleton

interface AuthApi{
    suspend fun login(loginRequest: LoginRequest): Result<Unit, DataError>
    suspend fun register(registerDto: RegisterDto): Result<String, DataError>
}

class AuthNetworkApi(
    private val client: HttpClient
): AuthApi {


    override suspend fun login(
        loginRequest: LoginRequest
    ): Result<Unit, DataError>{
        val connectionString: String = SecurityConstants.BACKEND_URL + "auth/login"

        return try{
            val response: HttpResponse = client.post(connectionString){
                setBody(loginRequest)
            }

            if (response.status.value in 200..299) {
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

        val connectionString: String = SecurityConstants.BACKEND_URL + "auth/register"

        return try {
            val response: HttpResponse = client.post(connectionString){
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