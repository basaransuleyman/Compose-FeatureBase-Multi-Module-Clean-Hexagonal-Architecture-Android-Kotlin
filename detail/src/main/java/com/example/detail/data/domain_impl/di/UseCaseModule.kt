package com.example.detail.data.domain_impl.di

import com.example.core.utils.IODispatcher
import com.example.detail.data.api.datasource.DetailDataSource
import com.example.detail.data.domain_impl.usecase.GetItemDetailUseCaseImpl
import com.example.detail.domain.usecase.GetItemDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideIODispatcher(): CoroutineContext {
        return Dispatchers.IO
    }

    @Provides
    @Singleton
    fun provideGetDetailUseCase(
        dataSource: DetailDataSource,
        @IODispatcher dispatcher: CoroutineContext
    ): GetItemDetailUseCase {
        return GetItemDetailUseCaseImpl(dataSource, dispatcher)
    }
}