package com.example.list.presentation.state

import androidx.compose.runtime.Immutable
import com.example.list.domain.model.ListData

@Immutable
data class ListUIState(
    val listData: ListData?,
    val isLoading: Boolean = false,
    val error: Throwable? = null
)