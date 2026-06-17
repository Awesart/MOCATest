package org.example.project.commonUI.Auth.registerComplete

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import loginscreentest.composeapp.generated.resources.Res
import loginscreentest.composeapp.generated.resources.check_circle
import org.example.project.commonUI.theme.descriptionColor
import org.example.project.commonUI.theme.elements.NoteMarkRectangle
import org.example.project.commonUI.theme.elements.NoteMarkRoundedButton
import org.jetbrains.compose.resources.painterResource

@Composable
fun RegisterComplete(
    onContinue: () -> Unit
){

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

            Image(
                painter = painterResource(Res.drawable.check_circle),
                contentDescription = "Checkmark",
            )

            Spacer(modifier = Modifier.fillMaxHeight(0.1f))

            Text(
                text = "Success!",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "Your registration was successful. You're ready to go!",
                style = MaterialTheme.typography.titleMedium,
                color = descriptionColor,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                modifier = Modifier.widthIn(200.dp, 290.dp)
            )


            Spacer(modifier = Modifier.weight(1f))

            NoteMarkRoundedButton(
                onClick = onContinue,
                "Continue",
                modifier = Modifier.fillMaxWidth(.95f)
            )

            Spacer(modifier = Modifier.weight(0.025f))

        }
    }


}