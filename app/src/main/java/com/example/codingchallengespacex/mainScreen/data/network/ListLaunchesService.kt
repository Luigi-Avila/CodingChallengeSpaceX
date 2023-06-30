package com.example.codingchallengespacex.mainScreen.data.network

import android.util.Log
import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.core.utils.toDomain
import com.example.codingchallengespacex.mainScreen.domain.models.LaunchItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListLaunchesService(private val apiClient: ListLaunchesClient) {

    suspend fun getListLaunches(): ResultGetLaunches<List<LaunchItem>>{
        return withContext(Dispatchers.IO){
            try {
                val response = apiClient.getListLaunches()
                Log.i("Algo salio mal", "Valor del body ${response.body()}")
                ResultGetLaunches.Success(response.body()?.map {
                    Log.i("PRueba", "${it.toDomain().details}")
                    it.toDomain()} ?: emptyList()
                )
            } catch (e: Exception){
                ResultGetLaunches.Error(e.message.toString())
            }

        }
    }
}