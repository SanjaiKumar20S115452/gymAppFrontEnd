package com.sanjai.stediofitness.presentation.navigation.screen.choosed_session.composable

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.sanjai.stediofitness.data.util.UiEvent
import com.sanjai.stediofitness.presentation.navigation.screen.choosed_session.ChoosedSessionViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ChoosedSessionScreen(
    viewModel: ChoosedSessionViewModel = hiltViewModel(),
    onNavigate: (UiEvent.OnNavigate) -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collectLatest { result ->
            when(result) {
                is UiEvent.OnNavigate -> {
                    onNavigate(result)
                }else -> Unit
            }
        }
    }
    val allCardio by viewModel.allCardio.collectAsState()
    val allStrengthening by viewModel.allStrengthening.collectAsState()
    val passedSession = viewModel.passedSession.value
    Scaffold {
        if(passedSession == "cardio") {
            ChoosedSessionContent(
                items = allCardio,
                onEvent = viewModel::onEvent
            )
        }else {
            ChoosedSessionContent2(
                item = allStrengthening,
                onEvent = viewModel::onEvent
            )
        }
    }
}