package com.example.codingchallengespacex.mainscreen.domain.repository

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem

interface IListLaunchesRepository {

    suspend fun getList(): ResultGetLaunches<List<LaunchItem>>
}