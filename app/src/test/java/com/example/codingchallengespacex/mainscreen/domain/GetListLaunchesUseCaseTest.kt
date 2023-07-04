package com.example.codingchallengespacex.mainscreen.domain

import com.example.codingchallengespacex.core.utils.ResultState
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import com.example.codingchallengespacex.mainscreen.domain.repository.IListLaunchesRepository
import com.example.codingchallengespacex.mainscreen.domain.useCase.GetListLaunchesUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetListLaunchesUseCaseTest {

    @RelaxedMockK
    private lateinit var repository: IListLaunchesRepository

    lateinit var getListLaunchesUseCase: GetListLaunchesUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getListLaunchesUseCase = GetListLaunchesUseCase(repository)
    }

    @Test
    fun `when the api return something then get values`() = runBlocking {
        //Given
        val myList = ResultState.Success(listOf(
            LaunchItem(
                name = "Elon",
                date_utc = "test",
                id = "12345",
                details = "Elon musk launches",
                image = "http://image.com"
            )
        ))
        coEvery { repository.getList() } returns myList

        //When
        val result = getListLaunchesUseCase()

        //Then
        assert(result == myList)
    }
}