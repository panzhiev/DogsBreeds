package com.panzhiev.dogsbreeds.di.module

import com.panzhiev.ui.MainActivity
import com.panzhiev.ui.allbreeds.ui.DogsBreedsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [AndroidSupportInjectionModule::class])
interface ActivitiesModule {

    @ContributesAndroidInjector
    fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    fun allBreedsFragment(): DogsBreedsFragment
}
