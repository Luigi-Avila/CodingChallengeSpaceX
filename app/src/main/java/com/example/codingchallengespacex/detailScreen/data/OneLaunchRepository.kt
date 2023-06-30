package com.example.codingchallengespacex.detailScreen.data

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.detailScreen.data.models.Launch
import com.example.codingchallengespacex.detailScreen.data.network.OneLaunchService
import com.example.codingchallengespacex.detailScreen.domain.repository.IOneLaunchRepository

class OneLaunchRepository(private val service: OneLaunchService) : IOneLaunchRepository {

    override suspend fun getOneLaunch(launchId: String): ResultGetLaunches<Launch?> =
        service.getOneLaunch(launchId)
}