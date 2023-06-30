package com.example.codingchallengespacex.mainscreen.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallengespacex.core.utils.ResultGetLaunches
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import com.example.codingchallengespacex.mainscreen.domain.useCase.GetListLaunchesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListLaunchesViewModel(private val getListLaunchesUseCase: GetListLaunchesUseCase) : ViewModel() {

    private val _listLaunch = MutableLiveData<List<LaunchItem>?>()
    val listLaunch: LiveData<List<LaunchItem>?> = _listLaunch

    init {
        getListLaunches()
    }

    fun getListLaunches() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = getListLaunchesUseCase()) {
                is ResultGetLaunches.Error -> {
                    Log.i("RESULTAPI", "ERRooorrr ${result.message}")
                }

                is ResultGetLaunches.Success -> {

                    Log.i("RESULTAPI", "SUCCESSS ${result.data}")
                    withContext(Dispatchers.Main){
                        val newList  = result.data.reversed()
                        _listLaunch.value = newList
                    }
                }
            }
        }
    }

}