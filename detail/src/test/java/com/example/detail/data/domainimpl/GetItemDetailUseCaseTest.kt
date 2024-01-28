package com.example.detail.data.domainimpl

import com.example.detail.data.api.datasource.DetailDataSource
import com.example.detail.data.api.model.ItemDetailResponse
import com.example.detail.data.api.model.OtherProductResponse
import com.example.detail.data.domain_impl.mapper.mapToItemDetail
import com.example.detail.data.domain_impl.usecase.GetItemDetailUseCaseImpl
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
@ExperimentalCoroutinesApi
class GetItemDetailUseCaseTest {

    @Mock
    private lateinit var dataSource: DetailDataSource

    private lateinit var getItemDetailUseCaseImpl: GetItemDetailUseCaseImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        dataSource = mock()
        getItemDetailUseCaseImpl = GetItemDetailUseCaseImpl(dataSource, Dispatchers.Unconfined)
    }

    @Test
    fun `getDetail returns correct data`() = runTest {
        // Arrange
        val mockOtherProducts = listOf(
            OtherProductResponse(
                productImage = "image1.jpg",
                productName = "Product 1",
                subText = "Subtext 1"
            ),
            OtherProductResponse(
                productImage = "image2.jpg",
                productName = "Product 2",
                subText = "Subtext 2"
            )
        )
        val mockResponse = ItemDetailResponse(
            productId = "123",
            productImage = "image.jpg",
            productName = "Test Product",
            subText = "Test Subtext",
            share = "Share Text",
            productOptions = listOf("Option1", "Option2"),
            otherProducts = mockOtherProducts
        )

        `when`(dataSource.getDetail()).thenReturn(mockResponse)

        // Act
        val result = getItemDetailUseCaseImpl.getDetail().first()

        // Assert
        assertEquals(mockResponse.mapToItemDetail(), result)
        verify(dataSource).getDetail()
    }

}