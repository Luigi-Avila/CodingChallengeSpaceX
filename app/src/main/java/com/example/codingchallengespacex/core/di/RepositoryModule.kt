package com.example.codingchallengespacex.core.di

import com.example.codingchallengespacex.detailScreen.data.OneLaunchRepository
import com.example.codingchallengespacex.detailScreen.domain.repository.IOneLaunchRepository
import com.example.codingchallengespacex.mainScreen.data.ListLaunchesRepository
import com.example.codingchallengespacex.mainScreen.domain.repository.IListLaunchesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IListLaunchesRepository> { ListLaunchesRepository(get()) }
    single<IOneLaunchRepository> { OneLaunchRepository(get()) }
}