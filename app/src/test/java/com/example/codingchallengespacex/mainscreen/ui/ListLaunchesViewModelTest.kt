package com.example.codingchallengespacex.mainscreen.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.codingchallengespacex.core.domain.utils.ResultState
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import com.example.codingchallengespacex.mainscreen.domain.useCase.GetLaunchesUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ListLaunchesViewModelTest {

    @RelaxedMockK
    private lateinit var getListLaunchesUseCase: GetLaunchesUseCase

    lateinit var listLaunchesViewModel: ListLaunchesViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        listLaunchesViewModel = ListLaunchesViewModel(getListLaunchesUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `When view model is created at first time, loading`() = runTest {
        //Given
        val myList = listOf(
            LaunchItem(
                image = "testing",
                details = "Elon musk image",
                name = "Elon musk",
                date_utc = "Today",
                id = "1234"
            )
        )
        val myResult = ResultState.Success(myList)

        coEvery { getListLaunchesUseCase() } returns myResult

        //When
        listLaunchesViewModel.getListLaunches()
        delay(100)

        //Then
        assertEquals(ResultState.Loading, listLaunchesViewModel._listLaunch.value)
    }

}