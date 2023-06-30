package com.example.codingchallengespacex.detailscreen.domain.useCase

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch
import com.example.codingchallengespacex.detailscreen.domain.repository.IOneLaunchRepository

class GetOneLaunchUseCase(private val repository: IOneLaunchRepository) {

    suspend operator fun invoke(launchId: String): ResultGetLaunches<DetailLaunch> =
        repository.getOneLaunch(launchId)
}