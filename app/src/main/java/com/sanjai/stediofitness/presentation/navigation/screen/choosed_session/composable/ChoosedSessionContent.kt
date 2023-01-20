package com.sanjai.stediofitness.presentation.navigation.screen.choosed_session.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.sanjai.stediofitness.R
import com.sanjai.stediofitness.data.model.Cardio
import com.sanjai.stediofitness.data.model.Strengthening
import com.sanjai.stediofitness.data.util.Constants
import com.sanjai.stediofitness.presentation.navigation.screen.choose_session.ChooseSessionEvents
import com.sanjai.stediofitness.presentation.navigation.screen.choosed_session.ChoosedScreenEvent

@Composable
fun ChoosedSessionContent(
    items: List<Cardio>,
    onEvent: (ChoosedScreenEvent) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
    ){
        items(
            items = items
        ) { cardio ->
            ChoosedSessionContentItem(cardio = cardio, onEvent = onEvent)
        }
    }
}

@Composable
fun ChoosedSessionContent2(
    item: List<Strengthening>,
    onEvent: (ChoosedScreenEvent) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
    ){
        items(
            items = item
        ) { strengthening ->
            ChoosedSessionContentItem2(
                strengthening = strengthening,
                onEvent = onEvent
            )
        }
    }
}

@Composable
fun ChoosedSessionContentItem2(
    strengthening: Strengthening,
    onEvent: (ChoosedScreenEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(all = 10.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFbde0fe),
                shape = RoundedCornerShape(20.dp)
            )
            .clickable {
                onEvent(ChoosedScreenEvent.OnClassClicked(classId = strengthening.id))
            }
    ) {
        Column(
            modifier = Modifier
                .padding(all = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = Constants.BASE_URL + strengthening.image,
                contentDescription = null,
                modifier = Modifier.size(105.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = strengthening.exerciseName, fontSize = 17.sp, color = Color(0xFF264653), fontWeight = FontWeight.ExtraBold,modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun ChoosedSessionContentItem(
    cardio: Cardio,
    onEvent: (ChoosedScreenEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(all = 10.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFbde0fe),
                shape = RoundedCornerShape(20.dp)
            )
            .clickable {
                onEvent(ChoosedScreenEvent.OnClassClicked(classId = cardio.id))
            }
    ) {
        Column(
            modifier = Modifier
                .padding(all = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = Constants.BASE_URL + cardio.image,
                contentDescription = null,
                modifier = Modifier.size(105.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = cardio.exerciseName, fontSize = 17.sp, color = Color(0xFF264653), fontWeight = FontWeight.ExtraBold,modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Max time: ${cardio.time}", fontSize = 12.sp)
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = cardio.benefits,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 9.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}