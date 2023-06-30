package com.example.codingchallengespacex.core.di

import com.example.codingchallengespacex.detailscreen.ui.DetailViewModel
import com.example.codingchallengespacex.mainscreen.ui.ListLaunchesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ListLaunchesViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}