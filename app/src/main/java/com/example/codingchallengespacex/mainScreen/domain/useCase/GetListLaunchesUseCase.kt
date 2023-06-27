package com.example.codingchallengespacex.mainScreen.domain.useCase

import com.example.codingchallengespacex.core.utils.ResultGetListLaunches
import com.example.codingchallengespacex.mainScreen.data.ListLaunchesRepository
import com.example.codingchallengespacex.mainScreen.data.models.ListLaunches

class GetListLaunchesUseCase {

    private val repository = ListLaunchesRepository()

    suspend operator fun invoke():  ResultGetListLaunches<ListLaunches> = repository.getList()
}