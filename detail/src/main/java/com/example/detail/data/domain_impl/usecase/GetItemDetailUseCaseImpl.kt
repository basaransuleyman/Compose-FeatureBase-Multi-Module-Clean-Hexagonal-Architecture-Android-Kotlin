package com.example.detail.data.domain_impl.usecase

import com.example.core.utils.IODispatcher
import com.example.detail.data.api.datasource.DetailDataSource
import com.example.detail.data.domain_impl.mapper.mapToItemDetail
import com.example.detail.domain.model.ItemDetail
import com.example.detail.domain.usecase.GetItemDetailUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

internal class GetItemDetailUseCaseImpl @Inject constructor(
    private val dataSource: DetailDataSource,
    @IODispatcher private val dispatcher: CoroutineContext
) : GetItemDetailUseCase {
    override fun getDetail(): Flow<ItemDetail> =
        flow {
            val detailData = dataSource.getDetail().mapToItemDetail()
            emit(detailData)
        }.flowOn(dispatcher)
}