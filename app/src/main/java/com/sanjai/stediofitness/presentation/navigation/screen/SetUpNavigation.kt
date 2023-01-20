package com.sanjai.stediofitness.presentation.navigation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sanjai.stediofitness.presentation.navigation.Screen
import com.sanjai.stediofitness.presentation.navigation.screen.choose_session.composable.ChooseSessionScreen
import com.sanjai.stediofitness.presentation.navigation.screen.choosed_session.composable.ChoosedSessionScreen
import com.sanjai.stediofitness.presentation.navigation.screen.classes.composable.ClassesScreen

@Composable
fun SetUpNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ChooseSessionScreen.route
    ) {
        composable(
            route = Screen.ChooseSessionScreen.route
        ) {
            ChooseSessionScreen(onNavigate = {
                navController.navigate(it.route)
            })
        }
        composable(
            route = Screen.ChoosedSessionScreen.route + "?session={session}",
            arguments = listOf(
                navArgument("session") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            ChoosedSessionScreen(onNavigate = {
                navController.navigate(it.route)
            })
        }
        composable(
            route = Screen.ClassesScreen.route + "?classId={classId}",
            arguments = listOf(
                navArgument("classId") {
                    type = NavType.IntType
                }
            )
        ) {
            ClassesScreen()
        }
    }
}