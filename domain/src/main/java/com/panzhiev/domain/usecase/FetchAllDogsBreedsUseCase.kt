package com.panzhiev.domain.usecase

import com.panzhiev.domain.model.DogBreed
import com.panzhiev.domain.model.Result
import com.panzhiev.domain.repository.DogsBreedsRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class FetchAllDogsBreedsUseCase @Inject constructor(
    private val repository: DogsBreedsRepository
) {
    suspend operator fun invoke(): Result<List<DogBreed>> = repository.getAllDogsBreeds()
}