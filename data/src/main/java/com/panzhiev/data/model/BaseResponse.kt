package com.panzhiev.data.model

data class BaseResponse<T>(
    val message: T,
    val status: String?
)