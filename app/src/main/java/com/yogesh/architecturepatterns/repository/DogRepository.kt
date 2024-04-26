package com.yogesh.architecturepatterns.repository

import com.yogesh.architecturepatterns.model.DogResponse
import com.yogesh.architecturepatterns.network.ApiService
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

class DogRepository @Inject constructor(private val apiService: ApiService) {


    fun getDog1(apiListener: ApiListener) {
        apiService.getDog1().enqueue(object : Callback<DogResponse> {
            override fun onResponse(call: Call<DogResponse>, response: Response<DogResponse>) {
                if (response.isSuccessful) {
                    apiListener.onSuccess(response.body()!!, "dog")
                } else {
                    apiListener.onFailure(response.message() + " " + response.code())
                }
            }

            override fun onFailure(call: Call<DogResponse>, t: Throwable) {
                apiListener.onFailure(t.message.toString())
            }
        })
    }

    fun getDog2(): Flow<Resource<DogResponse>> = flow {
        emit(Resource.loading())
        emit(Resource.success(apiService.getDog2()))
    }.catch {
        val errorMessage = when (it) {
            is HttpException -> {
                it.message() + " " + it.code()
            }

            else -> {
                it.message
            }
        }
        emit(Resource.failed(errorMessage!!))
    }.flowOn(Dispatchers.IO)
}