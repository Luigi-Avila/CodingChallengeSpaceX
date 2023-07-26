package com.example.codingchallengespacex.galleryScreen.domain.usecase

import com.example.codingchallengespacex.core.domain.utils.UIState
import com.example.codingchallengespacex.detailscreen.domain.repository.IOneLaunchRepository
import javax.inject.Inject

class GetGalleryUseCase @Inject constructor(private val repository: IOneLaunchRepository) {

    suspend operator fun invoke(galleryId: String): UIState<List<String>> =
        repository.getGallery(galleryId)
}