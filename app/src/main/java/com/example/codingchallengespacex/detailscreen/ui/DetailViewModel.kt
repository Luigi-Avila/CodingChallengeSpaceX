package com.example.codingchallengespacex.detailscreen.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallengespacex.core.domain.utils.ResultState
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch
import com.example.codingchallengespacex.detailscreen.domain.useCase.GetOneLaunchUseCase
import com.example.codingchallengespacex.galleryScreen.domain.usecase.GetGalleryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getOneLaunchUseCase: GetOneLaunchUseCase,
    private val getGalleryUseCase: GetGalleryUseCase
) :
    ViewModel() {

    private val _launch = MutableLiveData<ResultState<DetailLaunch>>()
    val launch: LiveData<ResultState<DetailLaunch>> = _launch

    private val _images = MutableLiveData<ResultState<List<String>>> ()
    val images: LiveData<ResultState<List<String>>> = _images

    fun getOneLaunch(launchId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _launch.postValue(ResultState.Loading)
            withContext(Dispatchers.Main) {
                getOneLaunchUseCase(launchId).let {
                    _launch.value = it
                }
            }
        }
    }

    fun getGallery(galleryId: String){
        viewModelScope.launch(Dispatchers.IO) {
            _images.postValue(ResultState.Loading)
            withContext(Dispatchers.Main){
               getGalleryUseCase(galleryId).let {
                   _images.value = it
               }
            }
        }
    }

}