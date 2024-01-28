package com.example.detail.presentation

import com.example.core.navigation.NavigationService
import com.example.detail.domain.model.ItemDetail
import com.example.detail.domain.model.OtherProducts
import com.example.detail.domain.usecase.GetItemDetailUseCase
import com.example.detail.presentation.state.DetailUIState
import com.example.detail.presentation.uievent.DetailUIEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private val testDispatcher = TestCoroutineDispatcher()

    @Mock
    private lateinit var getItemDetail: GetItemDetailUseCase
    @Mock
    private lateinit var navigator: NavigationService

    private lateinit var viewModel: DetailViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)  // Set the main dispatcher to the test dispatcher
        viewModel = DetailViewModel(getItemDetail, navigator)
    }

    @Test
    fun `loadItemDetail updates uiState correctly`() = runTest {
        val itemDetail = ItemDetail(
            productImage = "image_url",
            productName = "Test Product",
            productId = "123",
            subText = "sub_text",
            review = null,
            questions = null,
            share = "share_text",
            otherProducts = listOf(
                OtherProducts(
                    productImage = "other_product_image_url",
                    productName = "Other Product Name",
                    subText = "Other Product Sub Text"
                )
            ),
            productOptions = listOf("Option 1", "Option 2")
        )

        `when`(getItemDetail.getDetail()).thenReturn(flowOf(itemDetail))

        val stateList = mutableListOf<DetailUIState>()
        val job = launch {
            viewModel.uiState.toList(stateList)
        }

        viewModel.onEvent(DetailUIEvent.LoadItemDetail)

        advanceUntilIdle()

        // Assert that uiState was updated correctly
        assertTrue("Expected state not found in stateList", stateList.any {
            it.itemData == itemDetail && !it.isLoading
        })

        job.cancel()
    }

    @Test
    fun `loadItemDetail updates uiState on error`() = runTest {
        val exception = RuntimeException("Test Exception")
        `when`(getItemDetail.getDetail()).thenReturn(flow { throw exception })

        viewModel.onEvent(DetailUIEvent.LoadItemDetail)

        val currentState = viewModel.uiState.value
        assertTrue(currentState.error === exception)
    }


    @Test
    fun `handleBack calls navigator goBack`() = runTest {
        viewModel.onEvent(DetailUIEvent.Dismiss)
        verify(navigator).goBack()
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()  // Reset the main dispatcher to the original one
        testDispatcher.cleanupTestCoroutines()
    }
}