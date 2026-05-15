package com.sonami.springboot_backend_moca

import com.sonami.springboot_backend_moca.repository.UserRepository

//BusinessLogic is handled here
class UserService(
    private val userRepository: UserRepository
) {

    fun getUser(userId: Long): UserDto{
        val foundUser = userRepository.getUser(userId)
        return foundUser
    }

    fun addUser(userDto: UserDto): UserDto{
        val addedUser = userRepository.addUser(userDto)
        return addedUser
    }

    fun updateUser(userDto: UserDto): UserDto{
        val updatedUser = userRepository.updateUser(userDto)
        return updatedUser
    }

    fun deleteUser(userId: Long): Boolean{
        val ifUserDeleted = userRepository.deleteUser(userId)
        return ifUserDeleted
    }

}