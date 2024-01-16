package com.example.home.data.api.datasource

import com.example.core.extensions.handleCall
import com.example.home.data.api.HomeApi
import com.example.home.data.api.model.HomeResponse
import javax.inject.Inject

internal class HomeDataSourceImpl @Inject constructor(
    private val api: HomeApi
) : HomeDataSource {
    override suspend fun getHome(): HomeResponse {
        return handleCall {
            api.getHome()
        }
    }

}