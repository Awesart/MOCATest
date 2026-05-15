package com.sonami.springboot_backend_moca.repository

import org.springframework.data.repository.CrudRepository


fun <T, ID> CrudRepository<T, ID>.findOne(id: ID): T? =  findById(id).orElse(null)