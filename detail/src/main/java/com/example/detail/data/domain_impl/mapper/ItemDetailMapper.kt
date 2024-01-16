package com.example.detail.data.domain_impl.mapper

import com.example.detail.data.api.model.ItemDetailResponse
import com.example.detail.data.api.model.OtherProductResponse
import com.example.detail.domain.model.ItemDetail
import com.example.detail.domain.model.OtherProducts

fun ItemDetailResponse.mapToItemDetail(): ItemDetail {

    return ItemDetail(
        productImage = this.productImage,
        productName = this.productName,
        productId = this.productId,
        subText = this.subText,
        review = this.review ?: "",
        questions = this.questions ?: "",
        share = this.share,
        otherProducts = this.otherProducts.toDomainProducts(),
        productOptions = this.productOptions
    )
}

private fun List<OtherProductResponse>?.toDomainProducts(): List<OtherProducts>? {
    return this?.map { responseProduct ->
        OtherProducts(
            productImage = responseProduct.productImage ?: "",
            productName = responseProduct.productName ?: "",
            subText = responseProduct.subText ?: ""
        )
    }
}