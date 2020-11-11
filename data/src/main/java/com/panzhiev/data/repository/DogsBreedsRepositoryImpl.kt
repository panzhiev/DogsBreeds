package com.panzhiev.data.repository

import com.panzhiev.data.apiservice.DogsBreedsApiService
import com.panzhiev.data.mapper.DogsBreedsMapper
import com.panzhiev.domain.model.DogBreed
import com.panzhiev.domain.model.Result
import com.panzhiev.domain.repository.DogsBreedsRepository
import javax.inject.Inject

class DogsBreedsRepositoryImpl @Inject constructor(
    private val apiService: DogsBreedsApiService,
    private val breedsMapper: DogsBreedsMapper
) : DogsBreedsRepository {

    override suspend fun getAllDogsBreeds(): Result<List<DogBreed>> =
        try {
            Result.Success(breedsMapper.toDomain(apiService.getAllBreeds().message))
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error
        }
}