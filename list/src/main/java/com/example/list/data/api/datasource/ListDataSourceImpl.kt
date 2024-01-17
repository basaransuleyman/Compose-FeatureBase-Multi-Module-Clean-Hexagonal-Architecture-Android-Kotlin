package com.example.list.data.api.datasource

import com.example.list.data.api.model.ListResponse
import javax.inject.Inject
import com.example.list.data.api.ListApi
import com.example.network.extensions.handleCall

internal class ListDataSourceImpl @Inject constructor(
    private val api: ListApi
) : ListDataSource {
    override suspend fun getList(): ListResponse {
        return handleCall {
            api.getList()
        }
    }
}