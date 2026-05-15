package com.sonami.springboot_backend_moca.repository

import com.sonami.springboot_backend_moca.UserDto
import com.sonami.springboot_backend_moca.UserNotFoundException
import org.springframework.stereotype.Repository

//Contains simple data manipulation logic
@Repository
class UserRepository {
    val users = mutableListOf<UserDto>()

    fun getUser(userId: Long): UserDto{
        val userToReturn = users.find{it.id == userId}

        return userToReturn ?: throw UserNotFoundException(userId)

    }

    fun addUser(userDto : UserDto): UserDto{
        users.add(userDto)
        return userDto
    }

    fun updateUser(userDto: UserDto): UserDto{
        val userIndex = users.indexOfFirst { it.id == userDto.id}

        return if(userIndex != -1){
            users[userIndex]
        }
        else{
            throw UserNotFoundException(userDto.id)
        }

    }

    fun deleteUser(userId: Long): Boolean{
        val userToDelete = users.indexOfFirst { it.id == userId}

        return if(userToDelete != -1){
            users.removeAt(userToDelete)
            true
        }
        else{
            throw UserNotFoundException(userId)
        }
    }

}