package com.example.codingchallengespacex.mainScreen.domain.repository

import com.example.codingchallengespacex.core.utils.ResultGetListLaunches
import com.example.codingchallengespacex.mainScreen.data.models.ListLaunches

interface IListLaunchesRepository {

    suspend fun getList(): ResultGetListLaunches<ListLaunches>
}