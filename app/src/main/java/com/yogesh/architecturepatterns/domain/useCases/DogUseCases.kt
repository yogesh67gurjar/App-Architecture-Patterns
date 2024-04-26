package com.yogesh.architecturepatterns.domain.useCases

import com.yogesh.architecturepatterns.data.model.DogResponse
import com.yogesh.architecturepatterns.presentation.repository.DogRepository
import com.yogesh.architecturepatterns.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class DogUseCases @Inject constructor(private val dogRepository: DogRepository) {
    fun getDog(): Flow<Resource<DogResponse>> = flow {
        emit(Resource.loading())
        emit(Resource.success(dogRepository.getDog()))
    }
        .catch {
            val errorMessage = when (it) {
                is HttpException -> {
                    it.message() + " " + it.code()
                }

                else -> {
                    it.message
                }
            }
            emit(Resource.failed(errorMessage!!))
        }


}