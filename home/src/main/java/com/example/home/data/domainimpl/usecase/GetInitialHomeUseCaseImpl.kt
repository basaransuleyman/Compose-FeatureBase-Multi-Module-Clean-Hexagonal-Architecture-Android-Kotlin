package com.example.home.data.domainimpl.usecase

import com.example.core.utils.IODispatcher
import com.example.home.data.api.datasource.HomeDataSource
import com.example.home.data.domainimpl.mapper.mapToHomeSections
import com.example.home.domain.model.HomeSections
import com.example.home.domain.usecase.GetInitialHomeUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

internal class GetInitialHomeUseCaseImpl @Inject constructor(
    private val dataSource: HomeDataSource,
    @IODispatcher private val dispatcher: CoroutineContext
) : GetInitialHomeUseCase {
    override fun getInitialHome(): Flow<HomeSections> =
        flow {
            val initialData = dataSource.getHome().mapToHomeSections()
            emit(initialData)
        }.flowOn(dispatcher)
}