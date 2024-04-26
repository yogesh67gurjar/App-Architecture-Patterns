package com.yogesh.architecturepatterns.di

import com.yogesh.architecturepatterns.data.network.ApiService
import com.yogesh.architecturepatterns.data.repository.DogRepositoryImplementation
import com.yogesh.architecturepatterns.presentation.repository.DogRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideBaseUrl(): String = "https://dog.ceo/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    fun providesDogRepository(apiService: ApiService): DogRepository {
        return DogRepositoryImplementation(apiService)
    }
}