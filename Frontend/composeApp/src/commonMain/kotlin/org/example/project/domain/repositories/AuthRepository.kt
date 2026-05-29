package org.example.project.domain.repositories

import org.example.project.data.network.AuthNetworkApi
import org.example.project.domain.errorHandling.DataError
import org.example.project.domain.errorHandling.Result
import org.example.project.data.models.LoginRequest
import org.example.project.data.models.RegisterDto

interface AuthRepository {
    suspend fun login(loginRequest: LoginRequest): Result<Unit, DataError>
    suspend fun register(registerDto: RegisterDto): Result<String, DataError>

}

class AuthRepositoryImpl(
    private val authNetworkApi: AuthNetworkApi
): AuthRepository{

    override suspend fun login(
        loginRequest: LoginRequest
    ): Result<Unit, DataError> {
        return authNetworkApi.login(loginRequest)
    }

    override suspend fun register(
        registerDto: RegisterDto
    ): Result<String, DataError> {
        return authNetworkApi.register(registerDto)
    }

}