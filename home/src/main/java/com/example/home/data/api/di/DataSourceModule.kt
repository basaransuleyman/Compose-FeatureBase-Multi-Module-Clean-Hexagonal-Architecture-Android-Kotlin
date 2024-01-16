package com.example.home.data.api.di

import com.example.home.data.api.HomeApi
import com.example.home.data.api.datasource.HomeDataSource
import com.example.home.data.api.datasource.HomeDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideHomeApi(retrofit: Retrofit): HomeApi {
        return retrofit.create(HomeApi::class.java)
    }

    @Singleton
    @Provides
    internal fun provideInitialResponseDataSource(apiService: HomeApi): HomeDataSource {
        return HomeDataSourceImpl(apiService)
    }

}