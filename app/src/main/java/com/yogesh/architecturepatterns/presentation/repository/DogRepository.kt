package com.yogesh.architecturepatterns.presentation.repository

import com.yogesh.architecturepatterns.data.model.DogResponse

interface DogRepository {
    suspend fun getDog(): DogResponse
}