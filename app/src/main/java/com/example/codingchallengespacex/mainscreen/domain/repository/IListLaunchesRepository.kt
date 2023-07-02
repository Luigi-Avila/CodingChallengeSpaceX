package com.example.codingchallengespacex.mainscreen.domain.repository

import com.example.codingchallengespacex.core.utils.ResultState
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem

interface IListLaunchesRepository {

    suspend fun getList(): ResultState<List<LaunchItem>>
}