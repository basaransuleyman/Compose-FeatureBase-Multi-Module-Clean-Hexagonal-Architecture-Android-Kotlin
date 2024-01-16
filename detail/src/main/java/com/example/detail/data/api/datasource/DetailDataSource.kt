package com.example.detail.data.api.datasource

import com.example.detail.data.api.model.ItemDetailResponse

interface DetailDataSource {
    suspend fun getDetail(): ItemDetailResponse
}


