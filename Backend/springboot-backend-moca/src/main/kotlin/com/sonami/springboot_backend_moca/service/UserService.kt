package com.sonami.springboot_backend_moca.service

import com.sonami.springboot_backend_moca.dto.UserDto
import com.sonami.springboot_backend_moca.exceptions.UserNotFoundException
import com.sonami.springboot_backend_moca.repository.UserRepository
import com.sonami.springboot_backend_moca.repository.findOne
import com.sonami.springboot_backend_moca.toDTO
import com.sonami.springboot_backend_moca.toEntity
import org.springframework.stereotype.Service

//BusinessLogic is handled here
@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getUser(userDto: UserDto): UserDto {
        val foundUserEntity = userRepository.findOne(userDto.id)

        return foundUserEntity?.toDTO() ?: throw UserNotFoundException(userDto.id)
    }

    fun addUser(
        user: UserDto
    ) {
        val newUser = user.toEntity()

        userRepository.save(newUser)
    }


}