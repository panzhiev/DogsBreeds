package com.panzhiev.data.mapper

import com.panzhiev.domain.model.DogBreed
import java.util.*
import javax.inject.Inject

class DogBreedsMapper @Inject constructor() {

    fun toDomain(breedsMap: Map<String, List<String>>): List<DogBreed> {

        val dogsBreeds = arrayListOf<DogBreed>()

        with(breedsMap) {
            forEach { (breedName, breedTypes) ->
                if (breedTypes.isEmpty()) {
                    dogsBreeds.add(
                        DogBreed(
                            breedName.capitalize(Locale.getDefault()),
                            breedName
                        )
                    )
                } else {
                    breedTypes.forEach { breedType ->
                        dogsBreeds.add(
                            DogBreed(
                                getFullBreedName(breedName, breedType),
                                "$breedName/$breedType"
                            )
                        )
                    }
                }
            }
        }

        return dogsBreeds
    }

    private fun getFullBreedName(breedName: String, breedType: String): String =
        "${breedName.capitalize(Locale.getDefault())} ${breedType.capitalize(Locale.getDefault())}"
}