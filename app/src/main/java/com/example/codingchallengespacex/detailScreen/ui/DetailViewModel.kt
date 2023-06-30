package com.example.codingchallengespacex.detailScreen.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.detailScreen.domain.models.DetailLaunch
import com.example.codingchallengespacex.detailScreen.domain.useCase.GetOneLaunchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(private val getOneLaunchUseCase: GetOneLaunchUseCase): ViewModel() {

    private val _launch = MutableLiveData<DetailLaunch?>()
    val launch: LiveData<DetailLaunch?> = _launch

    fun getOneLaunch(launchId: String){
        viewModelScope.launch(Dispatchers.IO) {
            when(val result = getOneLaunchUseCase(launchId)){
                is ResultGetLaunches.Error -> {
                    Log.i("Error", "Algo salio mal")
                }
                is ResultGetLaunches.Success -> {
                    Log.i("Todo chido", "Todo chido ${result.data}")
                    withContext(Dispatchers.Main){
                        _launch.value = result.data
                    }
                }
            }
        }
    }

}