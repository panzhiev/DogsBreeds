package com.panzhiev.ui.allbreeds.viewmodel

import androidx.lifecycle.viewModelScope
import com.panzhiev.domain.usecase.FetchAllDogsBreedsUseCase
import com.panzhiev.ui.base.BaseViewModel
import com.panzhiev.ui.base.Navigation
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class DogsBreedsViewModel @Inject constructor(
    private val fetchAllDogsBreedsUseCase: FetchAllDogsBreedsUseCase
) : BaseViewModel<Navigation>() {

    init {
        fetchAllBreeds()
    }

    private fun fetchAllBreeds() {
        viewModelScope.launch(IO) {
            handleResult(
                fetchAllDogsBreedsUseCase(),
                {},
                {}
            )
        }
    }
}