package com.example.codingchallengespacex.detailscreen.domain.repository

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch

interface IOneLaunchRepository {
    suspend fun getOneLaunch(launchId: String): ResultGetLaunches<DetailLaunch>
}