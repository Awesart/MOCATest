package org.example.project.navigation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSerializable
import androidx.compose.runtime.setValue
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberDecoratedNavEntries
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.savedstate.compose.serialization.serializers.MutableStateSerializer
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import org.example.project.navigation.api.Route


private val serializerConfig = SavedStateConfiguration{
    serializersModule = SerializersModule {
        polymorphic(NavKey::class){
            subclass(Route.Main.MainHome::class, Route.Main.MainHome.serializer())
            subclass(Route.Main.Test::class,Route.Main.Test.serializer())
            subclass(Route.Main.Stats::class, Route.Main.Stats.serializer())
            subclass(Route.Main.Settings::class, Route.Main.Settings.serializer())
        }
    }
}


//Hold multiple backStacks for reference.
class NavigationState(
    val startRoute: NavKey,
    topLevelRoute: MutableState<NavKey>,
    val backStacks: Map<NavKey, NavBackStack<NavKey>>

){

    //Holds the TopLevel Route of the current NavigationState
    var topLevelRoute by topLevelRoute

    //stacksInUse is like a top Level list of the routes.
    val stacksInUse: List<NavKey>
        get() = (if (topLevelRoute == startRoute){
            listOf(startRoute)
        }
        else{
            listOf(startRoute, topLevelRoute)
        })


    //Converts NavKey into a List of NavEntry.
    @Composable
    fun toDecoratedEntries(
        entryProvider: (NavKey) -> (NavEntry<NavKey>)
    ): List<NavEntry<NavKey>> {

        //Gives you the values of what's done after the function
        //As well as the keys of the backStacks map.
        val decoratedEntries = backStacks.mapValues { (_, stack) ->
            val decorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator<NavKey>(),
            )

            rememberDecoratedNavEntries(
                backStack = stack,
                entryDecorators = decorators,
                entryProvider = entryProvider
            )
        }

        return stacksInUse.flatMap { decoratedEntries[it] ?: emptyList() }

    }


}

@Composable
fun rememberNavigationState(
    startRoute: NavKey,
    topLevelRoutes: Set<NavKey>
): NavigationState{

    val topLevelRoute = rememberSerializable(
        startRoute,
        topLevelRoutes,
        configuration = serializerConfig,
        serializer = MutableStateSerializer(PolymorphicSerializer(NavKey::class)),

    ){
        mutableStateOf(startRoute)
    }

    //Returns a map with keys that are the current collection.
    //The values are then associated with the valueCollection function.
    //this means that bacKStacks will have a key of the topLevelRoutes and the backStack as the values.
    val backStacks = topLevelRoutes.associateWith { key ->
        rememberNavBackStack(
            serializerConfig,
            key
        )
    }

    return remember(startRoute, topLevelRoutes){
        NavigationState(
            startRoute,
            topLevelRoute,
            backStacks
        )
    }

}