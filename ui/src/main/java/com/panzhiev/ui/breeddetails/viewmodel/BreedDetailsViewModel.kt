package com.panzhiev.ui.breeddetails.viewmodel

import androidx.lifecycle.viewModelScope
import com.panzhiev.domain.model.DogBreed
import com.panzhiev.domain.usecase.FetchAllDogBreedsUseCase
import com.panzhiev.domain.usecase.FetchBreedImagesUseCase
import com.panzhiev.ui.allbreeds.viewmodel.DogBreedsNavigation
import com.panzhiev.ui.base.BaseViewModel
import com.panzhiev.ui.base.extensions.mutable
import com.panzhiev.ui.base.extensions.withProgress
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class BreedDetailsViewModel @Inject constructor(
    private val dogBreed: DogBreed,
    private val fetchBreedImageUseCase: FetchBreedImagesUseCase
) : BaseViewModel<BreedDetailsNavigation>() {

    val breedName = mutable(dogBreed.breedName)
    val breedImages = mutable<List<String>>()
    val isProgress = mutable<Boolean>()

    init {
        fetchImages()
    }

    fun fetchImages() {
        viewModelScope.launch(IO) {
            withProgress(isProgress) {
                handleResult(
                    fetchBreedImageUseCase(dogBreed.path),
                    { breedImages.postValue(it) },
                    { navigateTo(BreedDetailsNavigation.Error) }
                )
            }
        }
    }
}