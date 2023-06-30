package com.example.codingchallengespacex.detailScreen.data.network

import com.example.codingchallengespacex.detailScreen.data.models.LaunchDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface OneLaunchClient {
    @GET("/v4/launches/{id}")
    suspend fun getOneLaunch(@Path("id") id: String): Response<LaunchDTO>
}