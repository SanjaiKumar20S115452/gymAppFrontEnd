package com.sanjai.stediofitness.presentation.navigation.screen.classes

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanjai.stediofitness.data.model.StrengthClasses
import com.sanjai.stediofitness.data.util.Resource
import com.sanjai.stediofitness.domain.repository.StedioFitnessRemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClassesViewModel @Inject constructor(
    private val repository: StedioFitnessRemoteDataSource,
    savedStateHandle: SavedStateHandle
 ) : ViewModel() {

    init {
        val classId = savedStateHandle.get<Int>("classId")
        if(classId != -1) {
            classId?.let {
                getSelectedClasses(classId = it)
            }
        }
    }

    private val _selectedStrengthClass = MutableStateFlow<List<StrengthClasses>>(emptyList())
    val selectedStrengthClass: StateFlow<List<StrengthClasses>> = _selectedStrengthClass

     private fun getSelectedClasses(classId: Int) {
         viewModelScope.launch {
             repository.getSelectedStrengthClasses(classId).collectLatest { result ->
                 when(result) {
                     is Resource.Success -> {
                         result.data?.let {
                             _selectedStrengthClass.value = it
                         }
                     }
                     is Resource.Loading -> {}
                     is Resource.Error -> Unit
                 }
             }
         }
     }

 }