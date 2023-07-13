package com.example.codingchallengespacex.core.di.hilt

import com.example.codingchallengespacex.detailscreen.data.network.OneLaunchClient
import com.example.codingchallengespacex.mainscreen.data.network.ListLaunchesClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkHiltModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder().baseUrl("https://api.spacexdata.com")
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun provideListLaunchesClient(retrofit: Retrofit): ListLaunchesClient =
        retrofit.create(ListLaunchesClient::class.java)

    @Provides
    @Singleton
    fun provideOneLaunchClient(retrofit: Retrofit): OneLaunchClient =
        retrofit.create(OneLaunchClient::class.java)
}
