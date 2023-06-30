package com.example.codingchallengespacex.mainScreen.domain.repository

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.mainScreen.domain.models.LaunchItem

interface IListLaunchesRepository {

    suspend fun getList(): ResultGetLaunches<List<LaunchItem>>
}