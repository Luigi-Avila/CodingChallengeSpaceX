package com.example.codingchallengespacex.detailScreen.domain.useCase

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.detailScreen.data.models.Launch
import com.example.codingchallengespacex.detailScreen.domain.repository.IOneLaunchRepository

class GetOneLaunchUseCase(private val repository: IOneLaunchRepository) {

    suspend operator fun invoke(launchId: String): ResultGetLaunches<Launch?> =
        repository.getOneLaunch(launchId)
}