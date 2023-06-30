package com.example.codingchallengespacex.mainScreen.data

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.mainScreen.data.network.ListLaunchesService
import com.example.codingchallengespacex.mainScreen.domain.models.LaunchItem
import com.example.codingchallengespacex.mainScreen.domain.repository.IListLaunchesRepository

class ListLaunchesRepository(private val service: ListLaunchesService) : IListLaunchesRepository {

    override suspend fun getList(): ResultGetLaunches<List<LaunchItem>> =
        service.getListLaunches()
}