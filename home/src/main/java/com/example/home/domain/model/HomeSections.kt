package com.example.home.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class HomeSections(
    var sections: List<HomeSectionAdapterItem>
)

sealed class HomeSectionAdapterItem  {
    abstract val viewType: Int

    @Immutable
    data class Banner(
        override val viewType: Int = VIEW_TYPE_BANNER,
        val bannerItem: List<BannerItem>,
        val id: Int
    ) : HomeSectionAdapterItem()

    @Immutable
    data class SlidableProducts(
        override val viewType: Int = VIEW_TYPE_SLIDABLE_PRODUCTS,
        val productItem: List<ProductItem>,
        val sectionTitle: String,
        val id: Int
    ) : HomeSectionAdapterItem()

    @Immutable
    data class VerticalProducts(
        override val viewType: Int = VIEW_TYPE_VERTICAL_PRODUCTS,
        val productItem: List<ProductItem>,
        val sectionTitle: String,
        val id: Int
    ) : HomeSectionAdapterItem()


    companion object {
        const val VIEW_TYPE_BANNER = 1
        const val VIEW_TYPE_SLIDABLE_PRODUCTS = 2
        const val VIEW_TYPE_VERTICAL_PRODUCTS = 4
    }
}