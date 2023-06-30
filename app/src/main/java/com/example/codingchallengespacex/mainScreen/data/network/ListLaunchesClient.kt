package com.example.codingchallengespacex.mainScreen.data.network

import com.example.codingchallengespacex.mainScreen.data.models.LaunchesItemDTO
import retrofit2.Response
import retrofit2.http.GET

interface ListLaunchesClient {

    @GET("/v4/launches")
    suspend fun getListLaunches(): Response<List<LaunchesItemDTO>>
}