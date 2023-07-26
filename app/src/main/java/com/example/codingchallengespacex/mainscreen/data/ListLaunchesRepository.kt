package com.example.codingchallengespacex.mainscreen.data

import com.example.codingchallengespacex.core.domain.utils.ResultAPI
import com.example.codingchallengespacex.mainscreen.data.network.ListLaunchesService
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import com.example.codingchallengespacex.mainscreen.domain.repository.IListLaunchesRepository
import javax.inject.Inject

class ListLaunchesRepository @Inject constructor(private val service: ListLaunchesService) : IListLaunchesRepository {

    override suspend fun getList(): ResultAPI<List<LaunchItem>> =
        service.getListLaunches()
}