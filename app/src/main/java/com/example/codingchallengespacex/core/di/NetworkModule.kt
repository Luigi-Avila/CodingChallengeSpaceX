package com.example.codingchallengespacex.core.di

import com.example.codingchallengespacex.detailscreen.data.network.OneLaunchClient
import com.example.codingchallengespacex.mainscreen.data.network.ListLaunchesClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideRetrofit() }
    single { provideListLaunchesClient(get()) }
    single { provideOneLaunchClient(get()) }
}

fun provideRetrofit(): Retrofit = Retrofit.Builder()
    .baseUrl("https://api.spacexdata.com")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

fun provideListLaunchesClient(retrofit: Retrofit): ListLaunchesClient =
    retrofit.create(ListLaunchesClient::class.java)

fun provideOneLaunchClient(retrofit: Retrofit): OneLaunchClient =
    retrofit.create(OneLaunchClient::class.java)