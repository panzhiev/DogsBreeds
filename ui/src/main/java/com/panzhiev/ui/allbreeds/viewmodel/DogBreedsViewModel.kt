package com.panzhiev.ui.allbreeds.viewmodel

import androidx.lifecycle.viewModelScope
import com.panzhiev.domain.model.DogBreed
import com.panzhiev.domain.usecase.FetchAllDogBreedsUseCase
import com.panzhiev.ui.base.BaseViewModel
import com.panzhiev.ui.base.extensions.mutable
import com.panzhiev.ui.base.extensions.withProgress
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class DogBreedsViewModel @Inject constructor(
    private val fetchAllDogBreedsUseCase: FetchAllDogBreedsUseCase
) : BaseViewModel<DogBreedsNavigation>() {

    val breeds = mutable<List<DogBreed>>()
    val isProgress = mutable<Boolean>()

    init {
        fetchAllBreeds()
    }

    fun fetchAllBreeds() {
        viewModelScope.launch(IO) {
            withProgress(isProgress) {
                handleResult(
                    fetchAllDogBreedsUseCase(),
                    { breeds.postValue(it) },
                    { navigateTo(DogBreedsNavigation.Error) }
                )
            }
        }
    }
}