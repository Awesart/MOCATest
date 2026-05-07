package org.example.project.theme.elements

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import org.example.project.theme.buttonDisabledColor
import org.example.project.theme.buttonEnabledColor


@Composable
fun NoteMarkRoundedButton(
    onClick: () -> Unit,
    text: String,
    modifier : Modifier = Modifier) {

    val buttonColors = ButtonColors(
        buttonEnabledColor,
        Color.White,
        buttonDisabledColor,
        Color.White
    )

    Button(
        onClick = {onClick()},
        colors = buttonColors,
        modifier = modifier
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Medium

            )

    }
}