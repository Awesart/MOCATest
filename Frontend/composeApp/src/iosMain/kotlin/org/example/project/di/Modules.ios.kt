package org.example.project.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.example.project.database.UserDataStore
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<HttpClientEngine>{
        Darwin.create()
    }
}
actual val preferenceModule = module {
    single<UserDataStore>{
        Factory().createUserDataStore()
    }
}