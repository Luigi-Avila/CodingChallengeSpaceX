package com.example.codingchallengespacex.detailScreen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallengespacex.detailScreen.domain.useCase.GetOneLaunchUseCase
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    private val getOneLaunchUseCase = GetOneLaunchUseCase()

    fun getOneLaunch(launchId: String){
        viewModelScope.launch {
            getOneLaunchUseCase(launchId)
        }
    }

}