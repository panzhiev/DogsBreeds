package com.panzhiev.data.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("message") val data: T,
    val status: String?
)