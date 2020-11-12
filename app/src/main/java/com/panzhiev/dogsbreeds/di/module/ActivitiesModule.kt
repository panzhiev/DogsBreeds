package com.panzhiev.dogsbreeds.di.module

import com.panzhiev.dogsbreeds.di.annotation.PerActivity
import com.panzhiev.ui.MainActivity
import com.panzhiev.ui.allbreeds.ui.DogBreedsFragment
import com.panzhiev.ui.breeddetails.ui.BreedDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class])
interface ActivitiesModule {

    @PerActivity
    @ContributesAndroidInjector
    fun mainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector
    fun dogBreedsFragment(): DogBreedsFragment

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            BreedDetailsFragmentModule::class
        ]
    )
    fun breedDetailsFragment(): BreedDetailsFragment
}