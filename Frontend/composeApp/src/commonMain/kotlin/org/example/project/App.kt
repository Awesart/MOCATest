package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import org.example.project.navigation.ui.NavigateRoot

@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface{
            NavigateRoot()
        }
    }
}

