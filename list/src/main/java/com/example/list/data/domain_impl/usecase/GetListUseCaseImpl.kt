package com.example.list.data.domain_impl.usecase

import com.example.core.utils.IODispatcher
import com.example.list.data.api.datasource.ListDataSource
import com.example.list.data.domain_impl.mapper.mapToListData
import com.example.list.domain.model.ListData
import com.example.list.domain.usecase.GetListUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

internal class GetListUseCaseImpl @Inject constructor(
    private val dataSource: ListDataSource,
    @IODispatcher private val dispatcher: CoroutineContext
) : GetListUseCase {

    override fun getList(): Flow<ListData> =
        flow {
            val initialData = dataSource.getList().mapToListData()
            emit(initialData)
        }.flowOn(dispatcher)
}