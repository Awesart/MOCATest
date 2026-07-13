package org.example.project.navigation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.example.project.navigation.api.Route
import org.example.project.navigation.impl.mainHome
import org.example.project.navigation.impl.settings
import org.example.project.navigation.impl.stats
import org.example.project.navigation.impl.test

private val config = SavedStateConfiguration{
    serializersModule = SerializersModule {
        polymorphic(NavKey::class){
            subclass(Route.Main.MainHome::class, Route.Main.MainHome.serializer())
            subclass(Route.Main.Test::class,Route.Main.Test.serializer())
            subclass(Route.Main.Stats::class, Route.Main.Stats.serializer())
            subclass(Route.Main.Settings::class, Route.Main.Settings.serializer())
        }
    }
}





@Composable
fun NavigateMain(){

    val backStack = rememberNavBackStack(config, Route.Main.MainHome)

    val navigationState = rememberNavigationState(
        Route.Main.MainHome,
        TOP_LEVEL_DESTINATIONS.keys
    )

    val navigator = remember {Navigator(navigationState)}

    val entryProviders = entryProvider{
        mainHome()
        test()
        stats()
        settings()
    }

    Scaffold(
        bottomBar = {
                MainNavigationBar(
                selectedKey = navigationState.topLevelRoute,
                onSelectedKey = {
                    navigator.navigate(
                        navigationState.topLevelRoute
                    )
                }
            )   
        }
    ){
        NavDisplay(
            entries = navigationState.toDecoratedEntries(entryProviders),
            onBack = { navigator.goBack() }
        )
    }



}