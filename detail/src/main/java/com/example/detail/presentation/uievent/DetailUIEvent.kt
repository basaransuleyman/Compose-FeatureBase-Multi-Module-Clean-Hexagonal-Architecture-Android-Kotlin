package com.example.detail.presentation.uievent

sealed class DetailUIEvent {
    data class Navigate(val route: String) : DetailUIEvent()
    data object Dismiss : DetailUIEvent()
    data object LoadItemDetail : DetailUIEvent()
}