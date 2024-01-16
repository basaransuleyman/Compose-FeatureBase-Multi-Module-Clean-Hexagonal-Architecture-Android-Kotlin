package com.example.home.data.api.model

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("sections")
    val sections: List<Section>
)

data class Section(
    @SerializedName("sectionData")
    val sectionData: List<HomeSection>,
    val sectionTitle: String? = null,
    val type: Int
)

data class HomeSection(
    val icon: String? = null,
    val image: String,
    val navigationData: String? = null,
    val productId: String? = null,
    val productImage: String,
    val questions: String? = null,
    val rating: String? = null,
    val review: String? = null,
    val share: String? = null,
    val subText: String? = null,
    val text: String? = null,
    val piece: String? = null,
    val soldOutText: String? = null
)
