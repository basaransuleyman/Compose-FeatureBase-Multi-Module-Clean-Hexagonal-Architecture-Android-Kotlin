package com.example.list.data.api.datasource

import com.example.list.data.api.model.ListResponse
import javax.inject.Inject
import com.example.core.extensions.handleCall
import com.example.list.data.api.ListApi

internal class ListDataSourceImpl @Inject constructor(
    private val api: ListApi
) : ListDataSource {
    override suspend fun getList(): ListResponse {
        return handleCall {
            api.getList()
        }
    }
}