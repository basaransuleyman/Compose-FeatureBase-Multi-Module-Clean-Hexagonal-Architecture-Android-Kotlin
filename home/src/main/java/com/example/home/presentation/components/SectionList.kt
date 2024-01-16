package com.example.home.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.home.domain.model.HomeSectionAdapterItem
import com.example.home.presentation.uievent.HomeUIEvent

@Composable
fun SectionList(sections: List<HomeSectionAdapterItem>?, onEvent: (HomeUIEvent) -> Unit) {
    sections?.let {
        LazyColumn {
            items(it) { section ->
                SectionComponent(section, onEvent)
            }
        }
    }
}