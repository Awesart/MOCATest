package org.example.project.navigation.ui

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.example.project.navigation.api.Route
import org.example.project.navigation.impl.auth
import org.example.project.navigation.impl.main

private val config = SavedStateConfiguration{
    serializersModule = SerializersModule {
        polymorphic(NavKey::class){
            subclass(Route.Auth::class, Route.Auth.serializer())
            subclass(Route.Main::class,Route.Main.serializer())
        }
    }
}

@Composable
fun NavigateRoot(){

    val backStack = rememberNavBackStack(config, Route.Auth)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            auth(backStack)
            main()
        },
    )
}