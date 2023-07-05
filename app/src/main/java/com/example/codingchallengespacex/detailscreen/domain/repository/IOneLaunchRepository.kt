package com.example.codingchallengespacex.detailscreen.domain.repository

import com.example.codingchallengespacex.core.domain.utils.ResultState
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch

interface IOneLaunchRepository {
    suspend fun getOneLaunch(launchId: String): ResultState<DetailLaunch>
}