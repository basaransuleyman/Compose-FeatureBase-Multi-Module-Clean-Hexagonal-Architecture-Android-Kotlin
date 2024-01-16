package com.example.list.data.api

import com.example.list.data.api.model.ListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ListApi {

    @GET("/basaransuleyman/suleyman-basaranoglu-json/main/list-page-paging-first")
    suspend fun getList() : Response<ListResponse>

}