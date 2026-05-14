package org.example.project.commonUI.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.example.project.theme.elements.NoteMarkRectangle
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import org.example.project.theme.descriptionColor
import org.example.project.theme.elements.NoteMarkRoundedButton


@Composable
fun Home(
    onLoginClick: () -> Unit,
    onSignUpClick: ()-> Unit
)
{
    Surface {
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            NoteMarkRectangle(
                333.84f,
                130f,
                1.5f, 2.8f,
                1.5f, 2.8f,
                .465f, -0.4f,
                .5f, -0.5f,
                modifier = Modifier
                    .widthIn(max = 600.dp)
                    .heightIn(max = 200.dp)

            )
            Spacer(modifier = Modifier.fillMaxHeight(0.3f))
            HomeHeader()
            Spacer(modifier = Modifier.height(85.dp))
            HomeSection(onLoginClick, onSignUpClick)
            Spacer(modifier = Modifier.weight(1f))

            NoteMarkRectangle(
                190f,
                130f,
                1.5f, 2.8f,
                1.5f, 2.8f,
                -0.125f, -2.4f,
                -0.08f, -2.5f,
                modifier = Modifier
                    .widthIn(max = 600.dp)
                    .heightIn(max = 200.dp)

            )

        }
    }
}


@Composable
fun HomeHeader()
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){

        Text(
            text = "MoCA Cognition",
            fontWeight = FontWeight.Light,
            color = Color.Black,
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Left,
            modifier = Modifier.widthIn(200.dp, 290.dp)
        )

        Text(
            text = "Be safe, take a cognitive test. Today.",
            color = descriptionColor,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Left,
            modifier = Modifier.widthIn(200.dp, 290.dp)
        )

    }
}

@Composable
fun HomeSection(
    onLoginClick: () -> Unit,
    onSignUpClick: ()-> Unit
){

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        NoteMarkRoundedButton(
            onClick = onSignUpClick,
            "Get Started"
            )

        NoteMarkRoundedButton(
            onClick = onLoginClick,
            "Log in"
        )
    }
}