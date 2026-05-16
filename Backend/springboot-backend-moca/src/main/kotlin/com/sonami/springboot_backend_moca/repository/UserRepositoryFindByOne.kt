package com.sonami.springboot_backend_moca.repository

import org.springframework.data.repository.CrudRepository


fun <T: Any, ID: Any> CrudRepository<T, ID>.findOne(id: ID): T? = findById(id).orElse(null)