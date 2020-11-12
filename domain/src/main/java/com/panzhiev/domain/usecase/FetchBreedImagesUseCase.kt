package com.panzhiev.domain.usecase

import com.panzhiev.domain.model.Result
import com.panzhiev.domain.repository.DogBreedsRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class FetchBreedImagesUseCase @Inject constructor(
    private val repository: DogBreedsRepository
) {
    suspend operator fun invoke(breedPath: String): Result<List<String>> =
        repository.getBreedImages(breedPath)
}