package com.example.detail.data.api.datasource

import com.example.core.extensions.handleCall
import com.example.detail.data.api.DetailApi
import com.example.detail.data.api.model.ItemDetailResponse
import javax.inject.Inject

internal class DetailDataSourceImpl @Inject constructor(
    private val api: DetailApi
) : DetailDataSource {

    override suspend fun getDetail(): ItemDetailResponse {
        return handleCall {
            api.getDetail()
        }
    }
}