package com.example.home.presentation.state

import androidx.compose.runtime.Immutable
import com.example.home.domain.model.HomeSections
import com.example.home.domain.model.ProductItem

@Immutable
data class HomeUIState(
    val isLoading: Boolean = false,
    val homeData: HomeSections? = null,
    val error: Throwable? = null,
    val selectedProductItem: ProductItem? = null
)