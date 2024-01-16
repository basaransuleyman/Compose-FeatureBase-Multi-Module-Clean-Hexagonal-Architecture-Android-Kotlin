package com.example.detail.domain.usecase

import com.example.detail.domain.model.ItemDetail
import kotlinx.coroutines.flow.Flow

interface GetItemDetailUseCase {
    fun getDetail(): Flow<ItemDetail>
}