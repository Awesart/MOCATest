package org.example.project.commonUI.mainContent.mainHome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import loginscreentest.composeapp.generated.resources.Res
import loginscreentest.composeapp.generated.resources.orangutang
import org.example.project.commonUI.theme.elements.NoteMarkRoundedButton
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Preview
@Composable
fun MainHomeScreen(
    viewModel: MainHomeViewModel = koinViewModel()
){

    val userToken by viewModel.userSession.collectAsStateWithLifecycle()

    Column(
        Modifier.fillMaxSize()
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(Res.drawable.orangutang),
                contentDescription = "Fat Monkey",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )

            Text(
                text = userToken.token,
                modifier = Modifier.padding(5.dp, 0.dp)
            )

            NoteMarkRoundedButton(
                onClick = { viewModel.getUser() },
                text = "Test",
            )
        }

    }


}