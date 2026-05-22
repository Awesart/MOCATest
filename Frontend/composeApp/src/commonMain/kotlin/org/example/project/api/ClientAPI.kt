package org.example.project.api

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.descriptors.PrimitiveKind
import org.example.project.models.LoginRequest
import org.example.project.models.RegisterDto

class ClientAPI {
    companion object{
        const val BACKEND_URL: String = "http://localhost:8080/"
    }


    val client = HttpClient()

    suspend fun login(
        loginRequest: LoginRequest
    ){
        val connectionString: String = BACKEND_URL + "auth/login"

        val response: HttpResponse = client.post(connectionString){
            setBody(loginRequest)
        }

        if (response.status.value in 200..299) {
            println("Successful Response")
        }
        else{
            println("Unsuccessful response")
        }

    }

    suspend fun register(
        registerDto: RegisterDto
    ){
        val connectionString: String = BACKEND_URL + "auth/register"

        val response: HttpResponse = client.post(connectionString){
            setBody(registerDto)
        }

        if (response.status.value in 200..299) {
            println("Successful Response")
        }
        else{
            println("Unsuccessful response")
        }

    }

}