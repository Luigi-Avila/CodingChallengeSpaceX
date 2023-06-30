package com.example.codingchallengespacex.core.di

import com.example.codingchallengespacex.detailscreen.data.OneLaunchRepository
import com.example.codingchallengespacex.detailscreen.domain.repository.IOneLaunchRepository
import com.example.codingchallengespacex.mainscreen.data.ListLaunchesRepository
import com.example.codingchallengespacex.mainscreen.domain.repository.IListLaunchesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IListLaunchesRepository> { ListLaunchesRepository(get()) }
    single<IOneLaunchRepository> { OneLaunchRepository(get()) }
}