package org.example.project.commonUI.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import org.example.project.theme.elements.NoteMarkRoundedButton
import org.example.project.theme.elements.NoteMarkField
import org.example.project.theme.elements.NoteMarkRectangle
import org.example.project.theme.elements.NoteMarkTextButton


@Composable
fun Login(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit
) {

    Surface{
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            LoginHeader()
            Spacer(modifier = Modifier.height(85.dp))
            LoginSection(onLoginClick, onSignUpClick)
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
fun LoginHeader() {

    NoteMarkRectangle(
        -7f,
        130f,
        1.5f, 2.8f,
        1.5f, 2.8f,
        0.035f, -2.25f,
        0.05f, -2.33f

    )


    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Welcome back! Please login to your account",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.85f)
        )

    }
}

@Composable
fun LoginSection(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Column (
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(0.85f)
    ){
        NoteMarkField("Username", "Username", false)
        NoteMarkField("Password", "Password", true)
        Spacer(modifier = Modifier.height(10.dp))
        NoteMarkRoundedButton(
            onLoginClick,
            "Login",
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .fillMaxWidth(.8f))
        NoteMarkTextButton(
            onSignUpClick,
            "Don't Have an account?"
            )
    }


}
