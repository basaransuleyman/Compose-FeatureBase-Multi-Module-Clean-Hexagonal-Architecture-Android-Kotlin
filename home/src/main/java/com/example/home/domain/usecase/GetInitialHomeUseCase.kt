package com.example.home.domain.usecase

import com.example.home.domain.model.HomeSections
import kotlinx.coroutines.flow.Flow

interface GetInitialHomeUseCase {
    fun getInitialHome(): Flow<HomeSections>
}