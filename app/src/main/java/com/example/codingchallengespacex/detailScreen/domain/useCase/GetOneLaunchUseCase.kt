package com.example.codingchallengespacex.detailScreen.domain.useCase

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.detailScreen.data.OneLaunchRepository
import com.example.codingchallengespacex.detailScreen.data.models.Launch
import com.example.codingchallengespacex.detailScreen.data.network.OneLaunchService

class GetOneLaunchUseCase {

    private val repository = OneLaunchRepository()

    suspend operator fun invoke(launchId: String): ResultGetLaunches<Launch?> =
        repository.getOneLaunch(launchId)
}