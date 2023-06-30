package com.example.codingchallengespacex.detailScreen.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.detailScreen.data.models.Launch
import com.example.codingchallengespacex.detailScreen.domain.useCase.GetOneLaunchUseCase
import kotlinx.coroutines.launch

class DetailViewModel(private val getOneLaunchUseCase: GetOneLaunchUseCase): ViewModel() {

    private val _launch = MutableLiveData<Launch?>()
    val launch: LiveData<Launch?> = _launch

    fun getOneLaunch(launchId: String){
        viewModelScope.launch {
            when(val result = getOneLaunchUseCase(launchId)){
                is ResultGetLaunches.Error -> {
                    Log.i("Error", "Algo salio mal")
                }
                is ResultGetLaunches.Success -> {
                    Log.i("Todo chido", "Todo chido ${result.data}")
                    Log.i("Todo chido", "Las fotos ${result.data?.links?.flickr?.original.toString()}")

                    _launch.value = result.data
                }
            }
        }
    }

}