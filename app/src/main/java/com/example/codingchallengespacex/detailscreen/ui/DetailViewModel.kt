package com.example.codingchallengespacex.detailscreen.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallengespacex.core.domain.utils.ResultState
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch
import com.example.codingchallengespacex.detailscreen.domain.useCase.GetOneLaunchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(private val getOneLaunchUseCase: GetOneLaunchUseCase): ViewModel() {

    private val _launch = MutableLiveData<ResultState<DetailLaunch>>()
    val launch: LiveData<ResultState<DetailLaunch>> = _launch

    fun getOneLaunch(launchId: String){
        viewModelScope.launch(Dispatchers.IO) {
            _launch.postValue(ResultState.Loading)
            withContext(Dispatchers.Main){
                getOneLaunchUseCase(launchId).let {
                    _launch.value = it
                }
            }
        }
    }

}