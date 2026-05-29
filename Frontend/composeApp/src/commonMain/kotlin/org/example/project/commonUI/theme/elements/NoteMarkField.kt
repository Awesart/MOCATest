package org.example.project.commonUI.theme.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import loginscreentest.composeapp.generated.resources.Res
import loginscreentest.composeapp.generated.resources.visibility_24px
import loginscreentest.composeapp.generated.resources.visibility_off_24px
import org.example.project.commonUI.theme.hintColor
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun NoteMarkField(
    label: String,
    hint: String,
    isInputSecret: Boolean,
    textFieldState: TextFieldState
){

    var passwordVisible by remember { mutableStateOf(false) }

    Column{
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge
        )

        Spacer(modifier = Modifier.size(8.dp))

        if (!isInputSecret){
            OutlinedTextField(
                state = textFieldState,
                lineLimits = TextFieldLineLimits.SingleLine,
                placeholder = {
                    Text (
                        text = hint,
                        style = MaterialTheme.typography.titleMediumEmphasized,
                        color = hintColor
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
        else{
            OutlinedSecureTextField(
                state = textFieldState,
                placeholder = {
                    Text (
                        text = hint,
                        style = MaterialTheme.typography.titleMediumEmphasized,
                        color = hintColor
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        painter = if(passwordVisible) painterResource(Res.drawable.visibility_off_24px) else painterResource(Res.drawable.visibility_24px),
                        contentDescription = "Toggle Password Visibility",
                        modifier = Modifier.clickable{ passwordVisible = !passwordVisible}
                    )
                },
                textObfuscationMode = if(passwordVisible) TextObfuscationMode.Visible else TextObfuscationMode.RevealLastTyped
            )

        }

    }

}
