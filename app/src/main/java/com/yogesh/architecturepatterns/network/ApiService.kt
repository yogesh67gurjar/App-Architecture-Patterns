package com.yogesh.architecturepatterns.network

import com.yogesh.architecturepatterns.model.DogResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/breeds/image/random")
    fun getDog1(): Call<DogResponse>

    @GET("api/breeds/image/random")
    suspend fun getDog2(): DogResponse
}