package org.example.project

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import org.example.project.data.datastore.createDataStore
import org.example.project.di.initKoin

fun MainViewController() = ComposeUIViewController (
    configure = {
        initKoin()
    }
){
    App(
        prefs = remember{
            createDataStore ()
        }
    )
}