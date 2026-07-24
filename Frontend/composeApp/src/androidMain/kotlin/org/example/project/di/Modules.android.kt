package org.example.project.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.example.project.database.UserDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val platformModule = module{
    single<HttpClientEngine> {
        OkHttp.create()
    }

}
actual val preferenceModule = module {
    single<UserDataStore>{
        Factory(androidContext()).createUserDataStore()
    }
}