package com.example.codingchallengespacex.core.di

import com.example.codingchallengespacex.detailscreen.domain.useCase.GetOneLaunchUseCase
import com.example.codingchallengespacex.mainscreen.domain.useCase.GetListLaunchesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetListLaunchesUseCase(get()) }
    single { GetOneLaunchUseCase(get()) }
}