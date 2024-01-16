package com.example.home.data.domainimpl.mapper

import com.example.home.data.api.model.HomeResponse
import com.example.home.data.api.model.HomeSection
import com.example.home.domain.model.BannerItem
import com.example.home.domain.model.CatalogItem
import com.example.home.domain.model.HomeSectionAdapterItem
import com.example.home.domain.model.HomeSections
import com.example.home.domain.model.ProductItem

fun HomeResponse.mapToHomeSections(): HomeSections {
    val homeSectionsAdapterItems = mutableListOf<HomeSectionAdapterItem>()

    this.sections.forEach { section ->
        val viewType = when (section.type) {
            1 -> HomeSectionAdapterItem.VIEW_TYPE_BANNER
            2 -> HomeSectionAdapterItem.VIEW_TYPE_SLIDABLE_PRODUCTS
            4 -> HomeSectionAdapterItem.VIEW_TYPE_VERTICAL_PRODUCTS
            else -> -1
        }

        val sectionItem = when (viewType) {
            HomeSectionAdapterItem.VIEW_TYPE_BANNER -> HomeSectionAdapterItem.Banner(
                viewType = viewType,
                bannerItem = section.sectionData.map { banner ->
                    mapHomeSectionToBannerItem(banner)
                }
            )

            HomeSectionAdapterItem.VIEW_TYPE_SLIDABLE_PRODUCTS -> HomeSectionAdapterItem.SlidableProducts(
                viewType = viewType,
                productItem = section.sectionData.map { product ->
                    mapToProductItem(product)
                },
                sectionTitle = section.sectionTitle ?: ""
            )

            HomeSectionAdapterItem.VIEW_TYPE_VERTICAL_PRODUCTS -> HomeSectionAdapterItem.VerticalProducts(
                viewType = viewType,
                productItem = section.sectionData.map { product ->
                    mapToProductItem(product)
                },
                sectionTitle = section.sectionTitle ?: ""
            )

            else -> null
        }

        sectionItem?.let { homeSectionsAdapterItems.add(it) }

    }
    return HomeSections(sections = homeSectionsAdapterItems)
}

private fun mapHomeSectionToCatalogItem(homeSection: HomeSection): CatalogItem {
    return CatalogItem(
        icon = homeSection.icon,
        text = homeSection.text
    )
}


private fun mapHomeSectionToBannerItem(homeSection: HomeSection): BannerItem {
    return BannerItem(
        image = homeSection.image,
        navigationData = homeSection.navigationData
    )
}


private fun mapToProductItem(response: HomeSection): ProductItem {
    return ProductItem(
        productId = response.productId,
        productImage = response.productImage,
        text = response.text,
        subText = response.subText,
        review = response.review,
        questions = response.questions,
        rating = response.rating,
        share = response.share,
        piece = response.piece,
        soldOutText = response.soldOutText
    )
}
