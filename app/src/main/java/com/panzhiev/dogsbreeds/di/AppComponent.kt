package com.panzhiev.dogsbreeds.di

import android.app.Application
import com.panzhiev.dogsbreeds.DogsBreedsApplication
import com.panzhiev.dogsbreeds.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton
import kotlin.time.ExperimentalTime

@ExperimentalTime
@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        GsonModule::class,
        RepositoryModule::class,
        ActivitiesModule::class
    ]
)
interface AppComponent : AndroidInjector<DogsBreedsApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}