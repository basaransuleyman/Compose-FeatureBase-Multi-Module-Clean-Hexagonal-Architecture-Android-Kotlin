package com.example.home.presentation.uievent

sealed class HomeUIEvent {
    data object OnBannerClicked : HomeUIEvent()
    data object LoadInitialHome : HomeUIEvent()
    data object OnProductClicked: HomeUIEvent()
}