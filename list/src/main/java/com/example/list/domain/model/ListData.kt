package com.example.list.domain.model

data class ListData(
    val productList: List<ListProductsModel>?,
    val productLimit: Int?,
    val  totalCount: Int?
)

data class ListProductsModel(
    val productId: String,
    val productImage: String,
    val text: String,
    val subText: String,
    val review: String,
    val questions: String,
    val rating: String
)
