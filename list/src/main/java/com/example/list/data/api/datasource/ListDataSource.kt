package com.example.list.data.api.datasource

import com.example.list.data.api.model.ListResponse

interface ListDataSource {
    suspend fun getList(): ListResponse
}