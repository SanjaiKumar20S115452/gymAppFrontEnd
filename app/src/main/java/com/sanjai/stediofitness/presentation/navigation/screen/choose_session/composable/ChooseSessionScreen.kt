package com.sanjai.stediofitness.presentation.navigation.screen.choose_session.composable

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.sanjai.stediofitness.data.util.UiEvent
import com.sanjai.stediofitness.presentation.navigation.screen.choose_session.ChooseSessionViewModelViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ChooseSessionScreen(
    viewModel: ChooseSessionViewModelViewModel = hiltViewModel(),
    onNavigate: (UiEvent.OnNavigate) -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collectLatest { event ->
            when(event) {
                is UiEvent.OnNavigate -> {
                    onNavigate(event)
                }else -> Unit
            }
        }
    }

    Scaffold {
        ChooseSessionContent(onEvent = viewModel::onEvent)
    }

}