package com.example.home.data.domainimpl.di

import com.example.core.utils.IODispatcher
import com.example.home.data.api.datasource.HomeDataSource
import com.example.home.data.domainimpl.usecase.GetInitialHomeUseCaseImpl
import com.example.home.domain.usecase.GetInitialHomeUseCase
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
    fun provideGetInitialHomeUseCase(
        dataSource: HomeDataSource,
        @IODispatcher dispatcher: CoroutineContext
    ): GetInitialHomeUseCase {
        return GetInitialHomeUseCaseImpl(dataSource, dispatcher)
    }
}