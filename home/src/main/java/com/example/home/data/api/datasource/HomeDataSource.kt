package com.example.home.data.api.datasource

import com.example.home.data.api.model.HomeResponse

interface HomeDataSource {
    suspend fun getHome(): HomeResponse
}