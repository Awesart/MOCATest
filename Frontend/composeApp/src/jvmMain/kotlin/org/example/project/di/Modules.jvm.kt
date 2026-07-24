package org.example.project.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule = module {
    single<HttpClientEngine>{
        OkHttp.create()
    }
}
actual val preferenceModule: Module
    get() = TODO("Not yet implemented")