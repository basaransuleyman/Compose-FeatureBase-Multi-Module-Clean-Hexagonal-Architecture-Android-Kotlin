package com.example.home.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.components.ErrorComponent
import com.example.core.components.LoadingComponent
import com.example.home.presentation.components.DetailBottomSheet
import com.example.home.presentation.components.HomeScreenContent
import com.example.home.presentation.uievent.HomeUIEvent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    LaunchedEffect(Unit) {
        viewModel.onEvent(HomeUIEvent.LoadInitialHome)
    }

    LaunchedEffect(state.selectedProductItem) {
        showBottomSheet = state.selectedProductItem != null
        if (showBottomSheet) {
            scope.launch { sheetState.show() }
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                viewModel.onEvent(HomeUIEvent.Dismiss)
                showBottomSheet = false
            },
        ) {
            state.selectedProductItem?.let { productItem ->
                DetailBottomSheet(productItem)
            }
        }
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