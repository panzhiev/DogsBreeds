package com.panzhiev.ui.allbreeds.viewmodel

import com.panzhiev.domain.model.DogBreed
import com.panzhiev.ui.base.Navigation

sealed class DogBreedsNavigation : Navigation {

    data class BreedDetails(val breed: DogBreed) : DogBreedsNavigation()
    object Error : DogBreedsNavigation()
}