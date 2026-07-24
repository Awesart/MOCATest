package org.example.project.navigation.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import org.example.project.commonUI.mainContent.SettingsScreen
import org.example.project.commonUI.mainContent.StatsScreen
import org.example.project.commonUI.mainContent.TestScreen
import org.example.project.commonUI.mainContent.mainHome.MainHomeScreen
import org.example.project.navigation.ui.NavigateMain
import org.example.project.navigation.api.Route

fun EntryProviderScope<NavKey>.main(){

    entry<Route.Main> {
        NavigateMain()
    }

}

fun EntryProviderScope<NavKey>.mainHome(){

    entry<Route.Main.MainHome> {
        MainHomeScreen()
    }

}

fun EntryProviderScope<NavKey>.test(){

    entry<Route.Main.Test> {
        TestScreen()
    }

}

fun EntryProviderScope<NavKey>.stats(){

    entry<Route.Main.Stats> {
        StatsScreen()
    }

}

fun EntryProviderScope<NavKey>.settings(){

    entry<Route.Main.Settings> {
        SettingsScreen()
    }

}