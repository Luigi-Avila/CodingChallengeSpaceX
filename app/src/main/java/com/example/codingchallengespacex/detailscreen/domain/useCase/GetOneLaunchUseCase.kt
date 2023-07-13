package com.example.codingchallengespacex.detailscreen.domain.useCase

import com.example.codingchallengespacex.core.domain.utils.ResultState
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch
import com.example.codingchallengespacex.detailscreen.domain.repository.IOneLaunchRepository
import javax.inject.Inject

class GetOneLaunchUseCase @Inject constructor(private val repository: IOneLaunchRepository) {

    suspend operator fun invoke(launchId: String): ResultState<DetailLaunch> =
        repository.getOneLaunch(launchId)
}