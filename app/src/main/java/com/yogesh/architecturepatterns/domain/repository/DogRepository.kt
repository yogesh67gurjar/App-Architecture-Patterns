package com.yogesh.architecturepatterns.domain.repository

import com.yogesh.architecturepatterns.data.model.DogResponse
import com.yogesh.architecturepatterns.data.network.ApiService
import com.yogesh.architecturepatterns.utils.ApiListener
import com.yogesh.architecturepatterns.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

interface DogRepository {
    fun getDog2(): DogResponse
}