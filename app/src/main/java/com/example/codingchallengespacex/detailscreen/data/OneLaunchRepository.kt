package com.example.codingchallengespacex.detailscreen.data

import com.example.codingchallengespacex.core.domain.utils.ResultState
import com.example.codingchallengespacex.detailscreen.data.network.OneLaunchService
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch
import com.example.codingchallengespacex.detailscreen.domain.repository.IOneLaunchRepository
import javax.inject.Inject

class OneLaunchRepository @Inject constructor(private val service: OneLaunchService) :
    IOneLaunchRepository {

    override suspend fun getOneLaunch(launchId: String): ResultState<DetailLaunch> =
        service.getOneLaunch(launchId)

    override suspend fun getGallery(galleryId: String): ResultState<List<String>> =
        service.getGallery(galleryId)
}