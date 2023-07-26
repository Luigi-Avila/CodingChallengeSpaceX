package com.example.codingchallengespacex.mainscreen.data.network

import com.example.codingchallengespacex.core.domain.utils.ResultAPI
import com.example.codingchallengespacex.core.domain.utils.toDomain
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ListLaunchesService @Inject constructor(private val apiClient: ListLaunchesClient) {

    suspend fun getListLaunches(): ResultAPI<List<LaunchItem>> {
        return withContext(Dispatchers.IO){
            try {
                val response = apiClient.getListLaunches()
                ResultAPI.Success(response.body()?.map { it.toDomain() } ?: emptyList())
            } catch (e: Exception){
                ResultAPI.Error(e.message.toString())
            }
        }
    }
}