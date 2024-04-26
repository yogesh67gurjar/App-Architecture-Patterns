package com.yogesh.architecturepatterns.data.repository

import com.yogesh.architecturepatterns.data.model.DogResponse
import com.yogesh.architecturepatterns.data.network.ApiService
import com.yogesh.architecturepatterns.presentation.repository.DogRepository
import javax.inject.Inject

class DogRepositoryImplementation @Inject constructor(private val apiService: ApiService) :
    DogRepository {
    override suspend fun getDog(): DogResponse = apiService.getDog2()
}