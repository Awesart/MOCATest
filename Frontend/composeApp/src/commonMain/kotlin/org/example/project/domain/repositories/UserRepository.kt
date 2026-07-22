package org.example.project.domain.repositories

import org.example.project.data.models.JWTRequest
import org.example.project.domain.errorHandling.DataError
import org.example.project.domain.errorHandling.Result


interface UserRepository{
    suspend fun setUserToken(request: JWTRequest): Result<Unit, DataError>
}

class UserRepositoryImpl (

): UserRepository{
    override suspend fun setUserToken(request: JWTRequest): Result<Unit, DataError> {
        TODO("Not yet implemented")
    }

}
