package com.panzhiev.domain.repository

import com.panzhiev.domain.model.DogBreed
import com.panzhiev.domain.model.Result

interface DogBreedsRepository {

    suspend fun getAllDogsBreeds(): Result<List<DogBreed>>
}