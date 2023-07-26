package com.example.codingchallengespacex.mainscreen.domain.repository

import com.example.codingchallengespacex.core.domain.utils.ResultAPI
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem

interface IListLaunchesRepository {

    suspend fun getList(): ResultAPI<List<LaunchItem>>
}