package org.example.project.commonUI.theme.elements

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.example.project.commonUI.theme.colorOfToBeClickedText

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