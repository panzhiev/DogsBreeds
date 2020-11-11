package com.panzhiev.dogsbreeds.di.module

import com.panzhiev.data.repository.DogBreedsRepositoryImpl
import com.panzhiev.domain.repository.DogBreedsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun dogsBreedsRepository(repository: DogBreedsRepositoryImpl): DogBreedsRepository
}