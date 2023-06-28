package com.example.codingchallengespacex.detailScreen.domain.repository

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.detailScreen.data.models.Launch

interface IOneLaunchRepository {
    suspend fun getOneLaunch(launchId: String): ResultGetLaunches<Launch?>
}