package com.example.codingchallengespacex.mainscreen.data.network

import com.example.codingchallengespacex.core.domain.utils.ResultState
import com.example.codingchallengespacex.core.domain.utils.toDomain
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListLaunchesService(private val apiClient: ListLaunchesClient) {

    suspend fun getListLaunches(): ResultState<List<LaunchItem>> {
        return withContext(Dispatchers.IO){
            try {
                val response = apiClient.getListLaunches()
                ResultState.Success(response.body()?.map { it.toDomain() } ?: emptyList())
            } catch (e: Exception){
                ResultState.Error(e.message.toString())
            }
        }
    }
}