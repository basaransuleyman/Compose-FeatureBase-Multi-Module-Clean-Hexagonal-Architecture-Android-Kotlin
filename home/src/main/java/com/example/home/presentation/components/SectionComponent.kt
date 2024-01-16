package com.example.home.presentation.components

import androidx.compose.runtime.Composable
import com.example.home.domain.model.HomeSectionAdapterItem
import com.example.home.presentation.sections.BannerSection
import com.example.home.presentation.sections.SlidableSection
import com.example.home.presentation.sections.VerticalSection
import com.example.home.presentation.uievent.HomeUIEvent

@Composable
fun SectionComponent(section: HomeSectionAdapterItem, onEvent: (HomeUIEvent) -> Unit) {
    when (section) {
        is HomeSectionAdapterItem.Banner -> BannerSection(
            section.bannerItem,
            onEvent
        )

        is HomeSectionAdapterItem.SlidableProducts -> SlidableSection(
            section.productItem,
            section.sectionTitle,
            onEvent
        )

        is HomeSectionAdapterItem.VerticalProducts -> VerticalSection(
            section.productItem,
            section.sectionTitle
        )
    }
}
