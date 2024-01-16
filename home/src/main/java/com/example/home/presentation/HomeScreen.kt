package com.example.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.components.ErrorComponent
import com.example.core.components.LoadingComponent
import com.example.home.presentation.components.HomeScreenContent
import com.example.home.presentation.uievent.HomeUIEvent

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onEvent(HomeUIEvent.LoadInitialHome)
    }

    when {
        state.isLoading -> LoadingComponent()
        state.error != null -> ErrorComponent(state.error)
        state.homeData != null -> {
            HomeScreenContent(
                homeData = state.homeData!!,
                onEvent = viewModel::onEvent
            )
        }
    }
}
