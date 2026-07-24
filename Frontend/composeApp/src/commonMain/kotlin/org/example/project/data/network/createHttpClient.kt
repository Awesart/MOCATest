package org.example.project.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.project.domain.repositories.UserRepository
import org.example.project.navigation.api.Route

fun createHttpClient(
    engine: HttpClientEngine,
): HttpClient{
    return HttpClient(engine){ 
        install(ContentNegotiation){
            json(
                json = Json{
                    ignoreUnknownKeys = true
                }
            )
        }
        defaultRequest{
            host="192.168.1.12"
            port = 8080
        }
        install(Auth){

        }

    }

}