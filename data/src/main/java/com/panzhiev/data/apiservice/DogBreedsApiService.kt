package com.panzhiev.data.apiservice

import com.panzhiev.data.model.BaseResponse
import retrofit2.http.GET

interface DogBreedsApiService {

    @GET("breeds/list/all")
    suspend fun getAllBreeds(): BaseResponse<Map<String, List<String>>>
}