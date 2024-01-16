package com.example.detail.domain.model

data class ItemDetail(
    val productImage: String,
    val productName: String,
    val productId: String,
    val subText: String,
    val review: String? = null,
    val questions: String? = null,
    val share: String,
    val otherProducts: List<OtherProducts>? = null,
    val productOptions: List<String>
)

data class OtherProducts(
    val productImage: String? = null,
    val productName: String? = null,
    val subText: String? = null
)