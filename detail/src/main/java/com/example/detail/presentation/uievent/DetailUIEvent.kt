package com.example.detail.presentation.uievent

sealed class DetailUIEvent {
    data object Dismiss : DetailUIEvent()
    data object LoadItemDetail : DetailUIEvent()
}