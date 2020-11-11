package com.panzhiev.dogsbreeds.di

import android.app.Application
import com.panzhiev.dogsbreeds.DogsBreedsApplication
import com.panzhiev.dogsbreeds.di.module.AppModule
import com.panzhiev.dogsbreeds.di.module.GsonModule
import com.panzhiev.dogsbreeds.di.module.NetworkModule
import com.panzhiev.dogsbreeds.di.module.RepositoryModule
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
        AndroidInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        GsonModule::class,
        RepositoryModule::class,
//        ActivitiesModule::class,
//        DbModule::class,
//        FlavorModule::class,
//        ServiceModule::class
    ]
)
interface AppComponent : AndroidInjector<DogsBreedsApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}