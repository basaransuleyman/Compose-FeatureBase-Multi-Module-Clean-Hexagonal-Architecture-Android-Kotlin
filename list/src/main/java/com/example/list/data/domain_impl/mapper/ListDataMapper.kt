package com.example.list.data.domain_impl.mapper

import com.example.list.data.api.model.ListProducts
import com.example.list.data.api.model.ListResponse
import com.example.list.domain.model.ListData
import com.example.list.domain.model.ListProductsModel

fun ListResponse.mapToListData(): ListData {
    val domainList = this.listResponse.map { it.toDomainProduct() }
    return ListData(
        productList = domainList,
        productLimit = this.productLimit,
        totalCount = this.totalCount
    )
}

private fun ListProducts.toDomainProduct(): ListProductsModel {
    return ListProductsModel(
        productId = this.productId,
        productImage = this.productImage,
        text = this.text,
        subText = this.subText,
        review = this.review,
        questions = this.questions,
        rating = this.rating
    )
}