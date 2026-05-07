package org.example.project.theme.elements

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import org.example.project.theme.buttonDisabledColor
import org.example.project.theme.buttonEnabledColor
import org.example.project.theme.colorOfToBeClickedText

@Composable
fun NoteMarkTextButton(
    onClick: () -> Unit,
    text: String,
    modifier : Modifier = Modifier) {


    TextButton(
        onClick = {onClick()},
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(
            contentColor = colorOfToBeClickedText
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium

        )

    }
}