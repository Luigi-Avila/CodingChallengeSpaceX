package com.example.codingchallengespacex.detailscreen.data.network

import com.example.codingchallengespacex.core.domain.utils.UIState
import com.example.codingchallengespacex.core.domain.utils.toDomainDetail
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OneLaunchService @Inject constructor(private val apiClient: OneLaunchClient) {

    suspend fun getOneLaunch(launchId: String): UIState<DetailLaunch> {
        return withContext(Dispatchers.IO){
            try {
                val response = apiClient.getOneLaunch(launchId)
                UIState.Success(response.body()?.toDomainDetail() ?: DetailLaunch())
            } catch (e: Exception){
                UIState.Error(e.message.toString())
            }

        }
    }

    suspend fun getGallery(galleryId: String): UIState<List<String>> {
        return withContext(Dispatchers.IO){
            try {
                val result = apiClient.getOneLaunch(galleryId)
                UIState.Success(result.body()?.toDomainDetail()?.images ?: emptyList())
            }catch (e: Exception){
                UIState.Error(e.message.toString())
            }
        }
    }
}