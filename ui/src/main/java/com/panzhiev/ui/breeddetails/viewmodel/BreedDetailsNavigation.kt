package com.panzhiev.ui.breeddetails.viewmodel

import com.panzhiev.ui.base.Navigation

sealed class BreedDetailsNavigation : Navigation {
    object Back : BreedDetailsNavigation()
    object Error : BreedDetailsNavigation()
}