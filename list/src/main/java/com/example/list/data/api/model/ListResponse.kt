package com.example.list.data.api.model

data class ListResponse(
    val listResponse: List<ListProducts>,
    val productLimit: Int,
    val totalCount: Int
)

data class ListProducts(
    val productId: String,
    val productImage: String,
    val text: String,
    val subText: String,
    val review: String,
    val questions: String,
    val rating: String
)