package org.example.project.di

import org.example.project.commonUI.Auth.login.LoginView
import org.example.project.commonUI.Auth.login.LoginViewModel
import org.example.project.commonUI.auth.viewModels.RegisterView
import org.example.project.commonUI.auth.viewModels.RegisterViewModel
import org.example.project.data.network.AuthApi
import org.example.project.data.network.AuthNetworkApi
import org.example.project.data.network.createHttpClient
import org.example.project.domain.repositories.AuthRepository
import org.example.project.domain.repositories.AuthRepositoryImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.viewModel

expect val platformModule: Module

val networkModule = module {

    singleOf(::createHttpClient)

    singleOf(::AuthNetworkApi).bind<AuthApi>()

}

val appModule = module{
    viewModelOf(::RegisterViewModel).bind<RegisterView>()
    viewModelOf(::LoginViewModel).bind<LoginView>()
}

val repositoryModule = module {
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}

