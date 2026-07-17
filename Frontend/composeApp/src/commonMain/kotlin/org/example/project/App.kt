package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.example.project.navigation.ui.NavigateRoot

@Composable
@Preview
fun App(
    prefs: DataStore<Preferences>
) {
    MaterialTheme {
        Surface{
            NavigateRoot()
        }
    }
}

