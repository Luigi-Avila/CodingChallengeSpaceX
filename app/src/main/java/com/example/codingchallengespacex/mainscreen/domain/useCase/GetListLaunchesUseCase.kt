package com.example.codingchallengespacex.mainscreen.domain.useCase

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import com.example.codingchallengespacex.mainscreen.domain.repository.IListLaunchesRepository

class GetListLaunchesUseCase(private val repository: IListLaunchesRepository) {
    suspend operator fun invoke(): ResultGetLaunches<List<LaunchItem>> =
        repository.getList()
}