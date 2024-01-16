package com.example.core.di

import com.example.core.utils.IODispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object CoroutineModule {

    @Provides
    @IODispatcher
    fun provideIODispatcher(): CoroutineContext = Dispatchers.IO
}