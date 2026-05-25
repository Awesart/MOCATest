package org.example.project.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.json

fun createHttpClient(engine: HttpClientEngine): HttpClient{
    return HttpClient(engine){
        install(ContentNegotiation){
            json()
        }


    }

}