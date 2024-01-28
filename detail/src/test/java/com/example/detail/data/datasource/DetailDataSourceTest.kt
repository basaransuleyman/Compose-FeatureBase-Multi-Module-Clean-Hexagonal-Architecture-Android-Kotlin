package com.example.detail.data.datasource

import com.example.core.model.GenericException
import com.example.detail.data.api.DetailApi
import com.example.detail.data.api.datasource.DetailDataSourceImpl
import com.example.detail.data.api.model.ItemDetailResponse
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

class DetailDataSourceTest {

    @Mock
    private lateinit var mockApi: DetailApi

    private lateinit var dataSource: DetailDataSourceImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        dataSource = DetailDataSourceImpl(mockApi)
    }

    @Test
    fun `getDetail returns valid response when api call is successful`() = runBlocking {
        // Given
        val expectedResponse = ItemDetailResponse(
            productId = "123",
            productImage = "image_url",
            productName = "Test Product",
            productOptions = listOf("Option 1", "Option 2"),
            share = "share_text",
            subText = "sub_text"
        )
        `when`(mockApi.getDetail()).thenReturn(Response.success(expectedResponse))

        // Act
        val actualResponse = dataSource.getDetail()

        // Assert
        assertEquals(expectedResponse, actualResponse)
    }

    @Test(expected = GenericException::class)
    fun `getDetail throws GenericException when api call is unsuccessful`(): Unit = runBlocking {
        // Arrange
        val errorResponse = Response.error<ItemDetailResponse>(404, ResponseBody.create(null, ""))
        `when`(mockApi.getDetail()).thenReturn(errorResponse)

        // Act & Assert
        dataSource.getDetail()
    }
}