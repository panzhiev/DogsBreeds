package com.panzhiev.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DogBreed(
    val breedName: String,
    val path: String
) : Parcelable