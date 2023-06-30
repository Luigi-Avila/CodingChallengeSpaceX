package com.example.codingchallengespacex.mainscreen.data.network

import com.example.codingchallengespacex.mainscreen.data.models.LaunchesItemDTO
import retrofit2.Response
import retrofit2.http.GET

interface ListLaunchesClient {

    @GET("/v4/launches")
    suspend fun getListLaunches(): Response<List<LaunchesItemDTO>>
}