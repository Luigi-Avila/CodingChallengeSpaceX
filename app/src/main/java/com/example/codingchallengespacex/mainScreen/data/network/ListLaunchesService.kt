package com.example.codingchallengespacex.mainScreen.data.network

import com.example.codingchallengespacex.core.RetrofitHelper
import com.example.codingchallengespacex.core.utils.ResultGetListLaunches
import com.example.codingchallengespacex.mainScreen.data.models.ListLaunches
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListLaunchesService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getListLaunches(): ResultGetListLaunches<ListLaunches>{
        return withContext(Dispatchers.IO){
            try {
                val response = retrofit.create(ListLaunchesClient::class.java).getListLaunches()
                ResultGetListLaunches.Success(response.body() ?: ListLaunches())
            } catch (e: Exception){
                ResultGetListLaunches.Error(e.message.toString())
            }

        }
    }
}