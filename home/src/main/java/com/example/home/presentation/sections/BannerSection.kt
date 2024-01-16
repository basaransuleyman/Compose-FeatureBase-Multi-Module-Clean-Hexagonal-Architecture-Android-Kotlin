package com.example.home.presentation.sections

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.core.components.CoilImageComponent
import com.example.home.domain.model.BannerItem
import com.example.home.presentation.uievent.HomeUIEvent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerSection(bannerItems: List<BannerItem>, onBannerClick: (HomeUIEvent) -> Unit) {

    val pagerState = rememberPagerState(initialPage = 0)

    AutoScrollBanner(pagerState, bannerItems.size)

    HorizontalPager(
        count = bannerItems.size,
        state = pagerState,
        modifier = Modifier
            .padding(20.dp)
            .height(200.dp)
            .fillMaxWidth()
    ) { page ->
        val bannerItem = bannerItems[page]
        CoilImageComponent(
            imageUrl = bannerItem.image,
            contentScale = ContentScale.FillBounds,
            onClick = {
                bannerItem.navigationData
                ?.let { HomeUIEvent.OnBannerClicked }
                ?.let { onBannerClick(it) }
            },
            contentDescription = "Banner Image"
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun AutoScrollBanner(pagerState: PagerState, itemCount: Int) {
    LaunchedEffect(pagerState) {
        while (isActive) {
            delay(3000)
            val nextPage = (pagerState.currentPage + 1) % itemCount
            pagerState.animateScrollToPage(nextPage)
        }
    }
}