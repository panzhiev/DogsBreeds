package com.panzhiev.dogsbreeds.di.module

import android.app.Application
import android.content.Context
import com.panzhiev.data.repository.DogsBreedsRepositoryImpl
import com.panzhiev.domain.repository.DogsBreedsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun dogsBreedsRepository(repository: DogsBreedsRepositoryImpl): DogsBreedsRepository
}