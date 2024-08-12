package com.example.bangkit_2024_made.TourismAppProject.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTourismResponse(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("places")
    val places: List<com.example.bangkit_2024_made.TourismAppProject.core.data.source.remote.response.TourismResponse>
)