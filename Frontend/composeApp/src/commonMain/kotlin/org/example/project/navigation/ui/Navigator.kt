package org.example.project.navigation.ui

import androidx.navigation3.runtime.NavKey
import org.example.project.navigation.api.Route

class Navigator(
    val state: NavigationState
) {
    fun navigate(route: NavKey){
        if(route in state.backStacks.keys){
            state.topLevelRoute = route
        }
        else{
            state.backStacks[state.topLevelRoute]?.add(route)
        }
    }

    fun goBack(){
        val currentStack = state.backStacks[state.topLevelRoute] ?:
        error("Stack for ${state.topLevelRoute} not found")

        val currentRoute = currentStack.last()

        if(currentRoute == state.topLevelRoute){
            state.topLevelRoute = state.startRoute
        }
        else{
            currentStack.removeLastOrNull()
        }

    }

}