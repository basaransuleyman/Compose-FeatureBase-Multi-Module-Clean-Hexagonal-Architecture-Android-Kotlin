package com.example.detail.presentation

import androidx.lifecycle.viewModelScope
import com.example.core.navigation.NavigationService
import com.example.core.presentation.StateAndEventViewModel
import com.example.detail.domain.usecase.GetItemDetailUseCase
import com.example.detail.presentation.state.DetailUIState
import com.example.detail.presentation.uievent.DetailUIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getItemDetail: GetItemDetailUseCase,
    private val navigator: NavigationService,
) : StateAndEventViewModel<DetailUIState, DetailUIEvent>(DetailUIState(null)) {

    private fun loadItemDetail() {
        viewModelScope.launch {
            getItemDetail.getDetail()
                .onStart {
                    updateUiState { copy(isLoading = true) }
                }
                .catch { exception ->
                    updateUiState { copy(error = exception) }
                }
                .collect {
                    updateUiState { copy(itemData = it, isLoading = false) }
                }
        }
    }

    private fun handleBack() {
        navigator.goBack()
    }

    private fun handleSearchDetailClick() {
        navigator.navigateTo("detail/search")
    }

    override suspend fun handleEvent(event: DetailUIEvent) {
        when (event) {
            is DetailUIEvent.Dismiss -> handleBack()
            is DetailUIEvent.LoadItemDetail -> loadItemDetail()
            is DetailUIEvent.SearchDetailClick -> handleSearchDetailClick()
        }
    }

}