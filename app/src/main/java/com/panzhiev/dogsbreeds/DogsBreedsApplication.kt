package com.panzhiev.dogsbreeds

import com.panzhiev.dogsbreeds.di.AppComponent
import com.panzhiev.dogsbreeds.di.DaggerAppComponent
import dagger.android.DaggerApplication
import kotlin.time.ExperimentalTime

@ExperimentalTime
class DogsBreedsApplication : DaggerApplication() {

    override fun applicationInjector() = this.appComponent

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}