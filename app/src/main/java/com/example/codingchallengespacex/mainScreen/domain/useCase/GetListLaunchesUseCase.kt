package com.example.codingchallengespacex.mainScreen.domain.useCase

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.mainScreen.data.models.ListLaunches
import com.example.codingchallengespacex.mainScreen.domain.repository.IListLaunchesRepository

class GetListLaunchesUseCase(private val repository: IListLaunchesRepository) {
    suspend operator fun invoke(): ResultGetLaunches<ListLaunches> =
        repository.getList()
}