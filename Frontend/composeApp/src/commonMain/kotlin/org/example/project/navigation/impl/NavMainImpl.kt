package org.example.project.navigation.impl

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import org.example.project.commonUI.MainContent.SettingsScreen
import org.example.project.commonUI.MainContent.StatsScreen
import org.example.project.commonUI.MainContent.TestScreen
import org.example.project.commonUI.MainContent.MainHomeScreen
import org.example.project.navigation.ui.NavigateMain
import org.example.project.navigation.api.Route

fun EntryProviderScope<NavKey>.main(){

    entry<Route.Main> {
        NavigateMain()
    }

}

fun EntryProviderScope<NavKey>.mainHome(backStack: NavBackStack<NavKey>){

    entry<Route.Main.MainHome> {
        MainHomeScreen()
    }

}

fun EntryProviderScope<NavKey>.test(backStack: NavBackStack<NavKey>){

    entry<Route.Main.MainHome> {
        TestScreen()
    }

}

fun EntryProviderScope<NavKey>.stats(backStack: NavBackStack<NavKey>){

    entry<Route.Main.MainHome> {
        StatsScreen()
    }

}

fun EntryProviderScope<NavKey>.settings(backStack: NavBackStack<NavKey>){

    entry<Route.Main.MainHome> {
        SettingsScreen()
    }

}