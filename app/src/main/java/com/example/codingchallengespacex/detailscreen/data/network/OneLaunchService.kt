package com.example.codingchallengespacex.detailscreen.data.network

import com.example.codingchallengespacex.core.domain.utils.ResultState
import com.example.codingchallengespacex.core.domain.utils.toDomainDetail
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class OneLaunchService(private val apiClient: OneLaunchClient) {

    suspend fun getOneLaunch(launchId: String): ResultState<DetailLaunch> {
        return withContext(Dispatchers.IO){
            try {
                val response = apiClient.getOneLaunch(launchId)
                ResultState.Success(response.body()?.toDomainDetail() ?: DetailLaunch())
            } catch (e: Exception){
                ResultState.Error(e.message.toString())
            }

        }
    }
}