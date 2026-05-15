package com.sonami.springboot_backend_moca.repository

import com.sonami.springboot_backend_moca.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface UserRepository : JpaRepository<UserEntity, Long> {


}
