package com.example.home.presentation.components

import androidx.compose.runtime.Composable
import com.example.home.domain.model.HomeSections
import com.example.home.presentation.uievent.HomeUIEvent

@Composable
fun HomeScreenContent(homeData: HomeSections, onEvent: (HomeUIEvent) -> Unit) {
    SectionList(homeData.sections, onEvent)
}