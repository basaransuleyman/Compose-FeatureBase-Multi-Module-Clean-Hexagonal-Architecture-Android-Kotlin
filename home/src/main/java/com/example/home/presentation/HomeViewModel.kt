package com.example.home.presentation

import androidx.lifecycle.viewModelScope
import com.example.core.presentation.StateAndEventViewModel
import com.example.home.domain.model.ProductItem
import com.example.home.domain.usecase.GetInitialHomeUseCase
import com.example.home.presentation.state.HomeUIState
import com.example.home.presentation.uievent.HomeUIEvent
import com.example.navigation.Destination
import com.example.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getInitialHomeUseCase: GetInitialHomeUseCase,
    private val navigator: Navigator
) : StateAndEventViewModel<HomeUIState, HomeUIEvent>(HomeUIState()) {
    override suspend fun handleEvent(event: HomeUIEvent) {
        when (event) {
            HomeUIEvent.LoadInitialHome -> {
                getInitialHome()
            }

            is HomeUIEvent.OnBannerClicked -> {
                onBannerClicked()
            }

            is HomeUIEvent.OnProductClicked -> {
                onProductClicked(true)
            }

            is HomeUIEvent.OnVerticalProductClicked -> {
                onVerticalProductClicked(event.item)
            }

            is HomeUIEvent.Dismiss -> {
                handleBack()
            }
        }
    }

    private fun getInitialHome() {
        viewModelScope.launch {
            getInitialHomeUseCase.getInitialHome()
                .onStart {
                    updateUiState { copy(isLoading = true) }
                }
                .catch { error ->
                    updateUiState { copy(error = error) }
                }
                .collect { homeSections ->
                    updateUiState {
                        copy(
                            homeData = homeSections,
                            isLoading = false,
                            selectedProductItem = null,
                            error = null
                        )
                    }
                }
        }
    }

    private fun onBannerClicked() {
        navigator.navigate(Destination.list.destination(Unit))
    }

    private fun onProductClicked(isSheetOpen: Boolean) {
        navigator.navigate(Destination.detail.destination(isSheetOpen)) {
            launchSingleTop = true
            restoreState = true
        }
    }

    private fun onVerticalProductClicked(productItem: ProductItem) {
        updateUiState {
            copy(selectedProductItem = productItem, isLoading = false)
        }
    }

    private fun handleBack() {
        navigator.back()
    }

}