package com.example.codingchallengespacex.mainscreen.ui

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallengespacex.core.domain.utils.ResultState
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import com.example.codingchallengespacex.mainscreen.domain.useCase.GetLaunchesDescriptionUseCase
import com.example.codingchallengespacex.mainscreen.domain.useCase.GetLaunchesGalleryUseCase
import com.example.codingchallengespacex.mainscreen.domain.useCase.GetLaunchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ListLaunchesViewModel @Inject constructor (
    private val getListLaunchesUseCase: GetLaunchesUseCase,
    private val getLaunchesGalleryUseCase: GetLaunchesGalleryUseCase,
    private val getLaunchesDescriptionUseCase: GetLaunchesDescriptionUseCase
) : ViewModel() {

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val _listLaunch = MutableLiveData<ResultState<List<LaunchItem>>>()
    val listLaunch: LiveData<ResultState<List<LaunchItem>>> = _listLaunch

    init {
        getListLaunches()
    }

    fun getListLaunches() {
        viewModelScope.launch(Dispatchers.IO) {
            _listLaunch.postValue(ResultState.Loading)
            withContext(Dispatchers.Main){
                getListLaunchesUseCase().let {
                    _listLaunch.value = it
                }
            }
        }
    }

    fun filterByLaunchGallery(launches: List<LaunchItem>){
        _listLaunch.value = ResultState.Loading
        _listLaunch.value = getLaunchesGalleryUseCase(launches)
    }

    fun filterByLaunchDescription(launches: List<LaunchItem>){
        _listLaunch.value = ResultState.Loading
        _listLaunch.value = getLaunchesDescriptionUseCase(launches)
    }

}