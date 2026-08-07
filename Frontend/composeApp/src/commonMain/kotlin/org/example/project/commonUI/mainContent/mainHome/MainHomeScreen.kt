package org.example.project.commonUI.MainContent.mainHome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import loginscreentest.composeapp.generated.resources.Plus
import loginscreentest.composeapp.generated.resources.Res
import loginscreentest.composeapp.generated.resources.clipboard_clinic
import loginscreentest.composeapp.generated.resources.orangutang
import loginscreentest.composeapp.generated.resources.plus_sign
import loginscreentest.composeapp.generated.resources.wvL2KJ_flowering_golden_medal_image
import org.example.project.commonUI.mainContent.mainHome.MainHomeViewModel
import org.example.project.commonUI.theme.buttonDisabledColor
import org.example.project.commonUI.theme.mHomeBorderColor
import org.example.project.commonUI.theme.mHomeStatsColor
import org.example.project.commonUI.theme.outsideRectangle
import org.example.project.data.models.LocalUserDto
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainHomeScreen(
    viewModel: MainHomeViewModel = koinViewModel()
){
    //Collect the state from the UI.
    val userSession by viewModel.userSession.collectAsStateWithLifecycle()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(userSession){
        //Get user detail using the userSession which stores the user's JWT
        viewModel.getUser(userSession)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item{
            UserHeader(uiState.username, uiState.email)
        }

        item{
            BlueTestSection()
        }

        item{
            RedTestSection()
        }

        leaderBoard(uiState.localUserList)

    }
}


fun LazyListScope.leaderBoard(
    users: List<LocalUserDto>
){
    items(users){ user ->
        LocalUserRow(
            username = user.localUsername,
            score = user.score
        )
    }

    item{
        AddLocalUserRow()
    }

}

@Preview
@Composable
fun AddLocalUserRow(){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .size(45.dp)
            .clip(RoundedCornerShape(14))
            .background(Color.LightGray)
            .clickable(
                onClick = {
                }
            ),
    ) {

        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(Color.Blue),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(Res.drawable.plus_sign),
                contentDescription = "Fat Monkey",
                contentScale = ContentScale.Crop,
                modifier = Modifier
            )
        }


        Text(
            text = "Add a new user",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(5.dp, 0.dp),
        )


    }

}

@Composable
fun LocalUserRow(
    username: String,
    score: Float
){

    val randomColors: List<Color> = listOf()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .size(45.dp)
            .clip(RoundedCornerShape(14))
            .background(Color.LightGray),
    ) {

        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = username.first().toString(),
                color = Color.White)
        }


        Text(
            text = username,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(5.dp, 0.dp),
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Text(
            text = score.toString(),
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(5.dp, 0.dp),
        )

    }
}

@Preview
@Composable
fun MainHomeScreenPreview(
) {

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {

        UserHeader("orangutang", "monkey@gmail.com")


        BlueTestSection()
        RedTestSection()
    }

}

@Composable
fun UserHeader(
    username: String,
    email: String
){
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

        Column {
            Text(
                text = username,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(5.dp, 0.dp),
            )

            Text(
                text = email,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(5.dp, 0.dp),
                color = Color.Gray,
            )
        }
    }
}

@Composable
fun RedTestSection(){
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .fillMaxHeight(.33f)
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
                    text = "View your performance",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    modifier = Modifier.padding(0.dp, 15.dp, 0.dp, 0.dp)
                        .fillMaxWidth(0.55f),
                )

                Text(
                    text = "Look at a visual display of your results and see if your ready to be on the road",
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
                        text = "View",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Light
                    )
                }

            }

            Image(
                painter = painterResource(Res.drawable.clipboard_clinic),
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

@Composable
fun BlueTestSection(){
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
