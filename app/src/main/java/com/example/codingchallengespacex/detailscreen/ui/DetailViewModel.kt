package com.example.codingchallengespacex.detailscreen.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallengespacex.core.domain.utils.UIState
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

    private val _launch = MutableLiveData<UIState<DetailLaunch>>()
    val launch: LiveData<UIState<DetailLaunch>> = _launch

    private val _images = MutableLiveData<UIState<List<String>>> ()
    val images: LiveData<UIState<List<String>>> = _images

    fun getOneLaunch(launchId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _launch.postValue(UIState.Loading)
            withContext(Dispatchers.Main) {
                getOneLaunchUseCase(launchId).let {
                    _launch.value = it
                }
            }
        }
    }

    fun getGallery(galleryId: String){
        viewModelScope.launch(Dispatchers.IO) {
            _images.postValue(UIState.Loading)
            withContext(Dispatchers.Main){
               getGalleryUseCase(galleryId).let {
                   _images.value = it
               }
            }
        }
    }

}