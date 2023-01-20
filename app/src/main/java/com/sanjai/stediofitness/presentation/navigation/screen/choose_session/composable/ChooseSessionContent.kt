package com.sanjai.stediofitness.presentation.navigation.screen.choose_session.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.sanjai.stediofitness.presentation.navigation.screen.choose_session.ChooseSessionEvents

@Composable
fun ChooseSessionContent(
    onEvent: (ChooseSessionEvents) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp)
        ) {
            ChooseSessionContentItem(onEvent)
            ChooseSessionContentItem2(onEvent)
        }
    }
}

@Composable
fun ChooseSessionContentItem(
    onEvent: (ChooseSessionEvents) -> Unit
) {
    Box(
        modifier = Modifier
            .border(
                shape = RoundedCornerShape(20.dp),
                width = 1.dp,
                color = Color(0xFFbde0fe)
            )
    ) {
        Column(
            modifier = Modifier
                .padding(all = 15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = com.sanjai.stediofitness.R.drawable.tredmill,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        onEvent(ChooseSessionEvents.OnSessionClicked(session = "cardio"))
                    }
                    .size(150.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "CARDIO", fontSize = 15.sp, fontWeight = FontWeight.ExtraBold)
        }
    }
}

@Composable
fun ChooseSessionContentItem2(
    onEvent: (ChooseSessionEvents) -> Unit
) {
    Box(
        modifier = Modifier
            .border(
                shape = RoundedCornerShape(20.dp),
                width = 1.dp,
                color = Color(0xFFbde0fe)
            )
    ) {
        Column(
            modifier = Modifier
                .padding(all = 15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = com.sanjai.stediofitness.R.drawable.strength,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        onEvent(ChooseSessionEvents.OnSessionClicked(session = "strength"))
                    }
                    .size(150.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "STRENGTHENING", fontSize = 15.sp, fontWeight = FontWeight.ExtraBold)
        }
    }
}