package com.panzhiev.data.apiservice

import okhttp3.Response
import retrofit2.http.GET

interface DogsBreedsApiService {

    @GET("breeds/list/all")
    suspend fun getAllBreeds(): Response
}