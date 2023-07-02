package com.example.codingchallengespacex.detailscreen.data

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.core.utils.ResultState
import com.example.codingchallengespacex.detailscreen.data.network.OneLaunchService
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch
import com.example.codingchallengespacex.detailscreen.domain.repository.IOneLaunchRepository

class OneLaunchRepository(private val service: OneLaunchService) : IOneLaunchRepository {

    override suspend fun getOneLaunch(launchId: String): ResultState<DetailLaunch> =
        service.getOneLaunch(launchId)
}