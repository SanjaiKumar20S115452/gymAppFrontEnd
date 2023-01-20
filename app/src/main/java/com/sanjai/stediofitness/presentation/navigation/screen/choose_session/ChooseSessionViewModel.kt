package com.sanjai.stediofitness.presentation.navigation.screen.choose_session

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanjai.stediofitness.data.util.UiEvent
import com.sanjai.stediofitness.presentation.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChooseSessionViewModelViewModel @Inject constructor() : ViewModel() {

 private val _uiEvent = Channel<UiEvent>()
 val uiEvent = _uiEvent.receiveAsFlow()

 fun onEvent(event: ChooseSessionEvents) {
  when(event) {
   is ChooseSessionEvents.OnSessionClicked -> {
    sendUiEvent(UiEvent.OnNavigate(route = Screen.ChoosedSessionScreen.route + "?session=${event.session}"))
   }
  }
 }

 private fun sendUiEvent(event: UiEvent) {
  viewModelScope.launch {
   _uiEvent.send(event)
  }
 }
 }
