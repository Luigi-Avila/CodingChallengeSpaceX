package com.example.codingchallengespacex.detailScreen.domain.repository

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.detailScreen.domain.models.DetailLaunch

interface IOneLaunchRepository {
    suspend fun getOneLaunch(launchId: String): ResultGetLaunches<DetailLaunch>
}