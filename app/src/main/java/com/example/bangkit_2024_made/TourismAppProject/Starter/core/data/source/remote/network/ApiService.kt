package com.example.bangkit_2024_made.TourismAppProject.Starter.core.data.source.remote.network

import com.example.bangkit_2024_made.TourismAppProject.Starter.core.data.source.remote.response.ListTourismResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("list")
    fun getList(): Call<ListTourismResponse>
}