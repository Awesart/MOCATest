package org.example.project.commonUI.MainContent.mainHome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import loginscreentest.composeapp.generated.resources.Res
import loginscreentest.composeapp.generated.resources.orangutang
import loginscreentest.composeapp.generated.resources.wvL2KJ_flowering_golden_medal_image
import org.example.project.commonUI.mainContent.mainHome.MainHomeViewModel
import org.example.project.commonUI.theme.buttonDisabledColor
import org.example.project.commonUI.theme.buttonEnabledColor
import org.example.project.commonUI.theme.elements.NoteMarkRoundedButton
import org.example.project.commonUI.theme.insideRectangle
import org.example.project.commonUI.theme.mHomeBorderColor
import org.example.project.commonUI.theme.mHomeStatsColor
import org.example.project.commonUI.theme.outsideRectangle
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainHomeScreen(
    viewModel: MainHomeViewModel = koinViewModel()
){
    //Collect the state from the UI.
    val userSession by viewModel.userSession.collectAsStateWithLifecycle()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        Modifier.fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(Res.drawable.orangutang),
                contentDescription = "Fat Monkey",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )

            Text(
                text = uiState.username,
                modifier = Modifier.padding(5.dp, 0.dp)
            )

            NoteMarkRoundedButton(
                onClick = { viewModel.getUser(userSession) },
                text = "Test",
            )
        }

    }
}

@Preview
@Composable
fun MainHomeScreenPreview(
) {

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(0.95f),
        ) {
            Image(
                painter = painterResource(Res.drawable.orangutang),
                contentDescription = "Fat Monkey",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )

            Text(
                text = "orangutang",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(5.dp, 25.dp),
            )
        }

            BlueSection()

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(.3f)
                .clip(RoundedCornerShape(10))
                .background(mHomeStatsColor),
        ) {
            Row(

            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(25.dp),
                    modifier = Modifier.padding(15.dp, 0.dp)
                ) {
                    Text(
                        text = "Test your cognitive ability",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Light,
                        color = Color.White,
                        modifier = Modifier.padding(0.dp, 15.dp, 0.dp, 0.dp)
                            .fillMaxWidth(0.55f),
                    )

                    Text(
                        text = "Take part in a Cognitive Assessment and verify your knowledge now.",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth(0.55f),
                    )

                    val buttonColors = ButtonColors(
                        Color.White,
                        outsideRectangle,
                        buttonDisabledColor,
                        Color.White
                    )

                    Button(
                        onClick = { },
                        colors = buttonColors,
                        shape = RoundedCornerShape(35),
                        modifier = Modifier.alpha(0.85f)
                    ) {
                        Text(
                            text = "Test",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Light
                        )
                    }

                }

                Image(
                    painter = painterResource(Res.drawable.wvL2KJ_flowering_golden_medal_image),
                    contentDescription = "Fat Monkey",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .rotate(345f)
                        .align(Alignment.Bottom)
                        .padding(15.dp, 15.dp, 0.dp, 0.dp)
                        .alpha(0.75f)
                )


            }
        }


    }
}

@Composable
fun BlueSection(){
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .fillMaxHeight(.25f)
            .clip(RoundedCornerShape(10))
            .background(mHomeBorderColor),
    ) {
        Row(

        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(25.dp),
                modifier = Modifier.padding(15.dp, 0.dp)
            ) {
                Text(
                    text = "Test your cognitive ability",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    modifier = Modifier.padding(0.dp, 15.dp, 0.dp, 0.dp)
                        .fillMaxWidth(0.55f),
                )

                Text(
                    text = "Take part in a Cognitive Assessment and verify your knowledge now.",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.55f),
                )

                val buttonColors = ButtonColors(
                    Color.White,
                    outsideRectangle,
                    buttonDisabledColor,
                    Color.White
                )

                Button(
                    onClick = { },
                    colors = buttonColors,
                    shape = RoundedCornerShape(35),
                    modifier = Modifier.alpha(0.85f)
                ) {
                    Text(
                        text = "Test",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Light
                    )
                }

            }

            Image(
                painter = painterResource(Res.drawable.wvL2KJ_flowering_golden_medal_image),
                contentDescription = "Fat Monkey",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .rotate(345f)
                    .align(Alignment.Bottom)
                    .padding(15.dp, 15.dp, 0.dp, 0.dp)
                    .alpha(0.75f)
            )


        }
    }
}
