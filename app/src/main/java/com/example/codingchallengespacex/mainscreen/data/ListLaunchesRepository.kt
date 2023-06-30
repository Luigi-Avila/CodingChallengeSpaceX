package com.example.codingchallengespacex.mainscreen.data

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.mainscreen.data.network.ListLaunchesService
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import com.example.codingchallengespacex.mainscreen.domain.repository.IListLaunchesRepository

class ListLaunchesRepository(private val service: ListLaunchesService) : IListLaunchesRepository {

    override suspend fun getList(): ResultGetLaunches<List<LaunchItem>> =
        service.getListLaunches()
}