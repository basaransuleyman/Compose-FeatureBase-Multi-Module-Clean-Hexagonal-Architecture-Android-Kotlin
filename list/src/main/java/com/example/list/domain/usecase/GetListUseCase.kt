package com.example.list.domain.usecase

import com.example.list.domain.model.ListData
import kotlinx.coroutines.flow.Flow

interface GetListUseCase {
    fun getList(): Flow<ListData>
}