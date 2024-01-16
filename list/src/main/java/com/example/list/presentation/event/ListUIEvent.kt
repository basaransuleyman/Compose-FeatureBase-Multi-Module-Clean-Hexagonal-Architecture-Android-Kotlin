package com.example.list.presentation.event

sealed interface ListUIEvent {
    data object Dismiss : ListUIEvent
    data object GetList: ListUIEvent
}