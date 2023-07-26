package com.example.codingchallengespacex.mainscreen.domain.useCase

import com.example.codingchallengespacex.core.domain.utils.ResultAPI
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import com.example.codingchallengespacex.mainscreen.domain.repository.IListLaunchesRepository
import javax.inject.Inject

class GetLaunchesUseCase @Inject constructor (private val repository: IListLaunchesRepository) {
    suspend operator fun invoke(): ResultAPI<List<LaunchItem>> = repository.getList()

}