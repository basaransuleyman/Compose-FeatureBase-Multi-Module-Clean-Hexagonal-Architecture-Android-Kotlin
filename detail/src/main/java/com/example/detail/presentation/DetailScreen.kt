package com.example.detail.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.components.ErrorComponent
import com.example.core.components.LoadingComponent
import com.example.detail.presentation.components.DetailContent
import com.example.detail.presentation.uievent.DetailUIEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen() {
    val viewModel: DetailViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsState()
    val bottomSheetState = rememberModalBottomSheetState()

    LaunchedEffect(Unit) {
        viewModel.onEvent(DetailUIEvent.LoadItemDetail)
    }

    when {
        state.isLoading -> { LoadingComponent() }
        state.error != null -> { ErrorComponent(error = state.error) }
        state.itemData != null -> {
            DetailContent(
                state.itemData!!,
                sheetState = bottomSheetState,
                onEvent = viewModel::onEvent
            )
        }
    }
}
