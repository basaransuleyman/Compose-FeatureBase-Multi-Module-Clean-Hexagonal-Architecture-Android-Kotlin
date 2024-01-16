package com.example.list.presentation.event

sealed interface ListUIEvent {
    data object Dismiss : ListUIEvent
    data class Navigate(val route: String) : ListUIEvent
    data object GetList: ListUIEvent
}