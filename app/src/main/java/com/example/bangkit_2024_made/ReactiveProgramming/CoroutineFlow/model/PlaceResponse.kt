package com.example.bangkit_2024_made.ReactiveProgramming.CoroutineFlow.model

import com.google.gson.annotations.SerializedName

data class PlaceResponse(
    @field:SerializedName("features")
    val features: List<PlacesItem>
)