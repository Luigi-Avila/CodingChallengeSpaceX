package com.example.codingchallengespacex.mainscreen.domain.useCase

import com.example.codingchallengespacex.core.domain.utils.ResultState
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import com.example.codingchallengespacex.mainscreen.domain.repository.IListLaunchesRepository
import javax.inject.Inject

class GetLaunchesUseCase @Inject constructor (private val repository: IListLaunchesRepository) {
    suspend operator fun invoke(): ResultState<List<LaunchItem>> {
        return when(val result = repository.getList()){
            is ResultState.Error -> result
            ResultState.Loading -> result
            is ResultState.Success -> {
                ResultState.Success(result.data.reversed())
            }
        }

    }

}