package com.sanjai.stediofitness.presentation.navigation.screen.classes.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.sanjai.stediofitness.presentation.navigation.screen.classes.ClassesViewModel

@Composable
fun ClassesScreen(
    viewModel: ClassesViewModel = hiltViewModel()
) {
    val allStrengthClasses by viewModel.selectedStrengthClass.collectAsState()
    Scaffold {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(
                items = allStrengthClasses
            ) { classes ->
                Text(text = classes.className)
            }
        }
    }
}