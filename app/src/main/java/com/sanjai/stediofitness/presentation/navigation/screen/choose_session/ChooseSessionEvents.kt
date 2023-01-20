package com.sanjai.stediofitness.presentation.navigation.screen.choose_session

sealed class ChooseSessionEvents {
    data class OnSessionClicked(val session: String): ChooseSessionEvents()
}
