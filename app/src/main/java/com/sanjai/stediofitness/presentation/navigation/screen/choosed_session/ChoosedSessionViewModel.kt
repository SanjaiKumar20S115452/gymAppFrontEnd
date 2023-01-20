package com.sanjai.stediofitness.presentation.navigation.screen.choosed_session

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanjai.stediofitness.data.api.StedioFitnessApi
import com.sanjai.stediofitness.data.model.Cardio
import com.sanjai.stediofitness.data.model.Strengthening
import com.sanjai.stediofitness.data.util.Resource
import com.sanjai.stediofitness.data.util.UiEvent
import com.sanjai.stediofitness.domain.repository.StedioFitnessRemoteDataSource
import com.sanjai.stediofitness.presentation.navigation.Screen
import com.sanjai.stediofitness.presentation.navigation.screen.choose_session.ChooseSessionEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChoosedSessionViewModel @Inject constructor(
    private val stedioFitnessRemoteDataSource: StedioFitnessRemoteDataSource,
    savedStateHandle: SavedStateHandle
 ) : ViewModel() {

    private val _allCardio = MutableStateFlow<List<Cardio>>(emptyList())
    val allCardio: StateFlow<List<Cardio>> = _allCardio

    private val _passedSession = mutableStateOf("")
    val passedSession: State<String> = _passedSession

     init {
         _passedSession.value = savedStateHandle["session"]!!
         if(_passedSession.value == "cardio") {
             viewModelScope.launch {
                 stedioFitnessRemoteDataSource.getAllCardio().collectLatest { result ->
                     when(result) {
                         is Resource.Success -> {
                             result.data?.let {
                                 _allCardio.value = it
                             }
                         }
                         is Resource.Loading -> {

                         }
                         is Resource.Error -> Unit
                     }
                 }
             }
         }
     }

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: ChoosedScreenEvent) {
        when(event) {
            is ChoosedScreenEvent.OnClassClicked -> {
                sendUiEvent(UiEvent.OnNavigate(route = Screen.ClassesScreen.route + "?classId=${event.classId}"))
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    private val _allStrengthening = MutableStateFlow<List<Strengthening>>(emptyList())
    val allStrengthening: StateFlow<List<Strengthening>> = _allStrengthening

    init {
        if(_passedSession.value == "strength") {
            viewModelScope.launch {
                stedioFitnessRemoteDataSource.getAllStrengthening().collectLatest { result ->
                    when(result) {
                        is Resource.Success -> {
                            result.data?.let {
                                _allStrengthening.value = it
                            }
                        }
                        is Resource.Loading -> Unit
                        is Resource.Error -> Unit
                    }
                }
            }
        }
    }

 }