package com.example.codingchallengespacex.detailScreen.data.network

import android.util.Log
import com.example.codingchallengespacex.core.RetrofitHelper
import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.detailScreen.data.models.Launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class OneLaunchService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getOneLaunch(launchId: String): ResultGetLaunches<Launch?>{
        return withContext(Dispatchers.IO){
            try {
                val response = retrofit.create(OneLaunchClient::class.java).getOneLaunch(launchId)
                Log.i("RESPONSAPI", "Valor del response ${response.body()}")
                ResultGetLaunches.Success(response.body())
            } catch (e: Exception){
                ResultGetLaunches.Error(e.message.toString())
            }

        }
    }
}