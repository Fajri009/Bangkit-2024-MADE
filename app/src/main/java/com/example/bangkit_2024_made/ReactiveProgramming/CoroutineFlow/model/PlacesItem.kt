package com.example.bangkit_2024_made.ReactiveProgramming.CoroutineFlow.model

import com.google.gson.annotations.SerializedName

data class PlacesItem(
    @field:SerializedName("place_name")
    val placeName: String
)