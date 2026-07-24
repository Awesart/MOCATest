package org.example.project.di

import org.example.project.commonUI.auth.login.LoginView
import org.example.project.commonUI.auth.login.LoginViewModel
import org.example.project.commonUI.mainContent.mainHome.MainHomeView
import org.example.project.commonUI.mainContent.mainHome.MainHomeViewModel
import org.example.project.commonUI.auth.viewModels.RegisterView
import org.example.project.commonUI.auth.viewModels.RegisterViewModel
import org.example.project.data.network.AuthApi
import org.example.project.data.network.AuthNetworkApi
import org.example.project.data.network.UserApi
import org.example.project.data.network.UserSessionNetworkApi
import org.example.project.data.network.createHttpClient
import org.example.project.domain.repositories.AuthRepository
import org.example.project.domain.repositories.AuthRepositoryImpl
import org.example.project.domain.repositories.UserRepository
import org.example.project.domain.repositories.UserRepositoryImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

expect val preferenceModule: Module

val networkModule = module {
    singleOf(::createHttpClient)
    singleOf(::AuthNetworkApi).bind<AuthApi>()
    singleOf(::UserSessionNetworkApi).bind<UserApi>()
}

val appModule = module{
    viewModelOf(::RegisterViewModel).bind<RegisterView>()
    viewModelOf(::LoginViewModel).bind<LoginView>()
    viewModelOf(::MainHomeViewModel).bind<MainHomeView>()
}

val repositoryModule = module {
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
    singleOf(::UserRepositoryImpl).bind<UserRepository>()
}

