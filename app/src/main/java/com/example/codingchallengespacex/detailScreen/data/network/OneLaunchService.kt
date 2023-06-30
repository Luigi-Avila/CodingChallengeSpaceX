package com.example.codingchallengespacex.detailScreen.data.network

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.detailScreen.data.models.Launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class OneLaunchService(private val apiClient: OneLaunchClient) {

    suspend fun getOneLaunch(launchId: String): ResultGetLaunches<Launch?>{
        return withContext(Dispatchers.IO){
            try {
                val response = apiClient.getOneLaunch(launchId)
                ResultGetLaunches.Success(response.body())
            } catch (e: Exception){
                ResultGetLaunches.Error(e.message.toString())
            }

        }
    }
}