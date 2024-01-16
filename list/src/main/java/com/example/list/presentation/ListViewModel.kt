package com.example.list.presentation

import androidx.lifecycle.viewModelScope
import com.example.core.presentation.StateAndEventViewModel
import com.example.list.domain.usecase.GetListUseCase
import com.example.list.presentation.event.ListUIEvent
import com.example.list.presentation.state.ListUIState
import com.example.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getListUseCase: GetListUseCase,
    private val navigator: Navigator
) : StateAndEventViewModel<ListUIState, ListUIEvent>(ListUIState(null)) {

    private fun getList() {
        viewModelScope.launch {
            getListUseCase.getList()
                .onStart {
                    updateUiState { copy(isLoading = true) }
                }
                .catch { error ->
                    updateUiState { copy(error = error) }
                }
                .collect { listData ->
                    updateUiState { copy(listData = listData, isLoading = false) }
                }

        }
    }

    private fun handleBack() {
        navigator.back()
    }

    override suspend fun handleEvent(event: ListUIEvent) {
        when (event) {
            is ListUIEvent.Dismiss -> handleBack()
            is ListUIEvent.GetList -> getList()
        }
    }
}