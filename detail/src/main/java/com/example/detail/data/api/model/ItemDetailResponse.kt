package com.example.detail.data.api.model

data class ItemDetailResponse(
    val productImage: String,
    val productName: String,
    val productId: String,
    val subText: String,
    val review: String? = null,
    val questions: String? = null,
    val share: String,
    val otherProducts: List<OtherProductResponse>? = null,
    val productOptions: List<String>
)

data class OtherProductResponse(
    val productImage: String? = null,
    val productName: String? = null,
    val subText: String? = null
)
