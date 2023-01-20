package com.sanjai.stediofitness.data.util

sealed class UiEvent {
    data class OnNavigate(val route: String, val argument: String = ""): UiEvent()
    data class ShowSnackBar(val message: String, val actionLabel: String): UiEvent()
    object PopBackStack: UiEvent()
}
