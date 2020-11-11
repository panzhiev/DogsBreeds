package com.panzhiev.domain.usecase

import com.panzhiev.domain.model.DogBreed
import com.panzhiev.domain.model.Result
import com.panzhiev.domain.repository.DogBreedsRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class FetchAllDogBreedsUseCase @Inject constructor(
    private val repository: DogBreedsRepository
) {
    suspend operator fun invoke(): Result<List<DogBreed>> = repository.getAllDogsBreeds()
}