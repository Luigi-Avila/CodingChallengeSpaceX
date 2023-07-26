package com.example.codingchallengespacex.mainscreen.domain.useCase

import com.example.codingchallengespacex.core.domain.utils.UIState
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import javax.inject.Inject

class GetLaunchesDescriptionUseCase @Inject constructor() {

    operator fun invoke(launches: List<LaunchItem>): UIState<List<LaunchItem>> =
        UIState.Success(launches.filter { it.hasDescription })

}