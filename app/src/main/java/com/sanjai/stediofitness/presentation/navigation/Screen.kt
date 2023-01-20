package com.sanjai.stediofitness.presentation.navigation

sealed class Screen(val route: String) {
    object ChooseSessionScreen: Screen("choose_session_screen")
    object ChoosedSessionScreen: Screen("choosed_session_screen")
    object ClassesScreen: Screen("classes_screen")
}