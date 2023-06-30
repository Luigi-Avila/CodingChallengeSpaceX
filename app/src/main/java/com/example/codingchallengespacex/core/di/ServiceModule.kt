package com.example.codingchallengespacex.core.di

import com.example.codingchallengespacex.detailscreen.data.network.OneLaunchService
import com.example.codingchallengespacex.mainscreen.data.network.ListLaunchesService
import org.koin.dsl.module

val serviceModule = module {
    single { ListLaunchesService(get()) }
    single { OneLaunchService(get()) }
}