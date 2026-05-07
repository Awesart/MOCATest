package org.example.project

import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.example.project.theme.elements.NoteMarkField
import org.example.project.theme.elements.NoteMarkRectangle
import org.example.project.theme.elements.NoteMarkRoundedButton
import org.example.project.theme.elements.NoteMarkTextButton
import org.example.project.theme.outsideRectangle

@Preview
@Composable
fun SignUp() {

    Surface{
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            SignUpHeader()
            Spacer(modifier = Modifier.height(80.dp))
            SignUpSection()
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
fun SignUpHeader() {

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
            text = "Register",
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(15.dp))
        Canvas(modifier = Modifier.fillMaxWidth()){
            drawLine(
                color = outsideRectangle,
                start = Offset(size.width * 0.45f, 0f),
                end = Offset(size.width * 0.55f, 0f),
                strokeWidth = 10f
            )
        }
    }
}

@Composable
fun SignUpSection() {
    Column (
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(0.85f)
    ){
        NoteMarkField("Name", "Name", false)
        NoteMarkField("Username", "Username", false)
        NoteMarkField("Password", "Password", true)
        Spacer(modifier = Modifier.height(10.dp))
        NoteMarkRoundedButton(
            ::placeHolderFunction,
            "Sign up ",
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .fillMaxWidth(.8f))

    }


}