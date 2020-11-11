package com.panzhiev.dogsbreeds

import com.panzhiev.dogsbreeds.di.AppComponent
import com.panzhiev.dogsbreeds.di.DaggerAppComponent
import dagger.android.DaggerApplication
import kotlin.time.ExperimentalTime

@ExperimentalTime
class DogsBreedsApplication : DaggerApplication() {

    override fun applicationInjector() = appComponent

    private val appComponent: AppComponent by lazy { DaggerAppComponent.factory().create(this) }
}