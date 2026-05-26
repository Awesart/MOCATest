package org.example.project.di

import org.example.project.data.AuthApi
import org.example.project.data.AuthNetworkApi
import org.example.project.data.createHttpClient
import org.example.project.domain.otherLogic.AuthRepository
import org.example.project.domain.otherLogic.AuthRepositoryImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val networkModule = module {

    singleOf(::createHttpClient)

    singleOf(::AuthNetworkApi).bind<AuthApi>()


}

val repositoryModule = module {
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}

