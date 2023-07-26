package com.example.codingchallengespacex.detailscreen.domain.repository

import com.example.codingchallengespacex.core.domain.utils.UIState
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch

interface IOneLaunchRepository {
    suspend fun getOneLaunch(launchId: String): UIState<DetailLaunch>

    suspend fun getGallery(launchId: String): UIState<List<String>>
}