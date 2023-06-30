package com.example.codingchallengespacex.mainScreen.data.network

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.mainScreen.data.models.ListLaunches
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListLaunchesService(private val apiClient: ListLaunchesClient) {

    suspend fun getListLaunches(): ResultGetLaunches<ListLaunches>{
        return withContext(Dispatchers.IO){
            try {
                val response = apiClient.getListLaunches()
                ResultGetLaunches.Success(response.body() ?: ListLaunches())
            } catch (e: Exception){
                ResultGetLaunches.Error(e.message.toString())
            }

        }
    }
}