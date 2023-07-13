package com.example.codingchallengespacex.core.di.hilt

import com.example.codingchallengespacex.detailscreen.data.OneLaunchRepository
import com.example.codingchallengespacex.detailscreen.domain.repository.IOneLaunchRepository
import com.example.codingchallengespacex.mainscreen.data.ListLaunchesRepository
import com.example.codingchallengespacex.mainscreen.domain.repository.IListLaunchesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryHiltModule {

    @Provides
    @Singleton
    fun provideListLaunchesRepository(
        listLaunchesRepository: ListLaunchesRepository
    ): IListLaunchesRepository = listLaunchesRepository

    @Provides
    @Singleton
    fun provideOneLaunchRepository(
        oneLaunchRepository: OneLaunchRepository
    ): IOneLaunchRepository = oneLaunchRepository

}
