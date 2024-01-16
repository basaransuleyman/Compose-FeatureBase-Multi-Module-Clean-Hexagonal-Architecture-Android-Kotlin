package com.example.list.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.components.ErrorComponent
import com.example.core.components.LoadingComponent
import com.example.list.presentation.components.ListContent
import com.example.list.presentation.event.ListUIEvent

@Composable
fun ListScreen() {

    val viewModel: ListViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onEvent(ListUIEvent.GetList)
    }

    when {
        state.isLoading -> { LoadingComponent() }
        state.error != null -> { ErrorComponent(error = state.error) }
        else -> state.listData?.let { listData ->
            ListContent(listData.productList ?: emptyList())
        }
    }

    BackHandler(enabled = true) {
        viewModel.onEvent(ListUIEvent.Dismiss)
    }
}