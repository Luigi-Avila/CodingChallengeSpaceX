package com.example.codingchallengespacex.mainScreen.data

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.mainScreen.data.models.ListLaunches
import com.example.codingchallengespacex.mainScreen.data.network.ListLaunchesService
import com.example.codingchallengespacex.mainScreen.domain.repository.IListLaunchesRepository

class ListLaunchesRepository: IListLaunchesRepository {

    private val service = ListLaunchesService()

    override suspend fun getList(): ResultGetLaunches<ListLaunches> = service.getListLaunches()
}