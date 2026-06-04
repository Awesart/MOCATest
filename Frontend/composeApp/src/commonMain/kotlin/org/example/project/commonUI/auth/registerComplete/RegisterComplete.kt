package org.example.project.commonUI.Auth.registerComplete

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.example.project.commonUI.theme.elements.NoteMarkRectangle

@Preview
@Composable
fun RegisterComplete(){

    Surface{
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            NoteMarkRectangle(
                -7f,
                130f,
                1.5f, 2.8f,
                1.5f, 2.8f,
                0.035f, -2.25f,
                0.05f, -2.33f

            )




        }
    }


}