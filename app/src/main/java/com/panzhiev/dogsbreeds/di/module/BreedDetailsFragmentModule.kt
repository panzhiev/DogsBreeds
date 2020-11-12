package com.panzhiev.dogsbreeds.di.module

import com.panzhiev.dogsbreeds.di.annotation.PerActivity
import com.panzhiev.domain.model.DogBreed
import com.panzhiev.ui.breeddetails.ui.BreedDetailsFragment
import dagger.Module
import dagger.Provides

@Module
class BreedDetailsFragmentModule {

    @Provides
    @PerActivity
    fun getDogBreed(fragment: BreedDetailsFragment): DogBreed =
        fragment.requireArguments()
            .getParcelable<DogBreed>(BreedDetailsFragment.ARG_DOG_BREED) as DogBreed
}