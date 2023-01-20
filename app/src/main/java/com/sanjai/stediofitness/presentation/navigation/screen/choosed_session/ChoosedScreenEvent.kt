package com.sanjai.stediofitness.presentation.navigation.screen.choosed_session

sealed class ChoosedScreenEvent {
    data class OnClassClicked(val classId: Int): ChoosedScreenEvent()
}
