package com.panzhiev.data.repository

import com.panzhiev.data.ResultHandler
import com.panzhiev.data.apiservice.DogBreedsApiService
import com.panzhiev.data.mapper.DogBreedsMapper
import com.panzhiev.data.model.BaseResponse
import com.panzhiev.domain.model.DogBreed
import com.panzhiev.domain.model.Result
import com.panzhiev.domain.repository.DogBreedsRepository
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class DogBreedsRepositoryImpl @Inject constructor(
    private val apiService: DogBreedsApiService,
    private val breedsMapper: DogBreedsMapper,
    private val resultHandler: ResultHandler
) : DogBreedsRepository {

    override suspend fun getAllDogsBreeds(): Result<List<DogBreed>> =
        resultHandler {
            breedsMapper.toDomain(apiService.getAllBreeds().data)
        }

    override suspend fun getBreedImages(breedPath: String): Result<List<String>> =
        resultHandler {
            val deferreds = arrayListOf<Deferred<BaseResponse<String>>>()
            for (i in 0 until 10) {
                deferreds.add(apiService.getBreedImageAsync(breedPath))
            }
            deferreds.map { it.await().data }
        }
}