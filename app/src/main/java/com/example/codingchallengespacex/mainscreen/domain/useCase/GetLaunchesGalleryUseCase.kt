package com.example.codingchallengespacex.mainscreen.domain.useCase

import com.example.codingchallengespacex.core.domain.utils.ResultState
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import javax.inject.Inject

class GetLaunchesGalleryUseCase @Inject constructor() {

    operator fun invoke(launches: List<LaunchItem>): ResultState<List<LaunchItem>> =
        ResultState.Success(launches.filter { it.hasGallery })

}