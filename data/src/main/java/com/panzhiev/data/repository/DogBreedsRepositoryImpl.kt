package com.panzhiev.data.repository

import com.panzhiev.data.apiservice.DogBreedsApiService
import com.panzhiev.data.mapper.DogBreedsMapper
import com.panzhiev.domain.model.DogBreed
import com.panzhiev.domain.model.Result
import com.panzhiev.domain.repository.DogBreedsRepository
import javax.inject.Inject

class DogBreedsRepositoryImpl @Inject constructor(
    private val apiService: DogBreedsApiService,
    private val breedsMapper: DogBreedsMapper
) : DogBreedsRepository {

    override suspend fun getAllDogsBreeds(): Result<List<DogBreed>> =
        try {
            Result.Success(breedsMapper.toDomain(apiService.getAllBreeds().message))
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e.message)
        }
}