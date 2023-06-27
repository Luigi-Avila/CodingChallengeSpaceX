package com.example.codingchallengespacex.mainScreen.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallengespacex.core.utils.ResultGetListLaunches
import com.example.codingchallengespacex.mainScreen.domain.useCase.GetListLaunchesUseCase
import kotlinx.coroutines.launch

class ListLaunchesViewModel: ViewModel() {

    private val getListLaunchesUseCase = GetListLaunchesUseCase()

    fun getListLaunches(){
        viewModelScope.launch {
            when(val result = getListLaunchesUseCase()){
                is ResultGetListLaunches.Error -> { Log.i("RESULTAPI", "ERRooorrr ${result.message}")}
                is ResultGetListLaunches.Success -> { Log.i("RESULTAPI", "SUCCESSS ${result.data}")}
            }
        }
    }
}