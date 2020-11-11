package com.panzhiev.dogsbreeds.di

import android.app.Application
import com.panzhiev.dogsbreeds.DogsBreedsApplication
import com.panzhiev.dogsbreeds.di.module.AppModule
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
//        ActivitiesModule::class,
//        RetrofitModule::class,
//        DbModule::class,
//        RepositoriesModule::class,
//        BuildTypeModule::class,
//        OkHttpModule::class,
//        ConfigModule::class,
//        GsonModule::class,
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