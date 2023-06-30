package com.example.codingchallengespacex.detailscreen.data.network

import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.core.utils.toDomainDetail
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class OneLaunchService(private val apiClient: OneLaunchClient) {

    suspend fun getOneLaunch(launchId: String): ResultGetLaunches<DetailLaunch>{
        return withContext(Dispatchers.IO){
            try {
                val response = apiClient.getOneLaunch(launchId)
                ResultGetLaunches.Success(response.body()?.toDomainDetail() ?: DetailLaunch() )
            } catch (e: Exception){
                ResultGetLaunches.Error(e.message.toString())
            }

        }
    }
}