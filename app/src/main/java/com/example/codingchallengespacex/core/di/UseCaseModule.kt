package com.example.codingchallengespacex.core.di

import com.example.codingchallengespacex.detailscreen.domain.useCase.GetOneLaunchUseCase
import com.example.codingchallengespacex.mainscreen.domain.useCase.GetLaunchesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetLaunchesUseCase(get()) }
    factory { GetOneLaunchUseCase(get()) }
}