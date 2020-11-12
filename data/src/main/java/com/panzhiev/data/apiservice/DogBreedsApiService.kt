package com.panzhiev.data.apiservice

import com.panzhiev.data.model.BaseResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface DogBreedsApiService {

    @GET("breeds/list/all")
    suspend fun getAllBreeds(): BaseResponse<Map<String, List<String>>>

    @GET("breed/{path}/images/random")
    fun getBreedImageAsync(@Path("path", encoded = true) path: String): Deferred<BaseResponse<String>>
}