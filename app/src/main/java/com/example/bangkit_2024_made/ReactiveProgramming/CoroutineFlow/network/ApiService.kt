package com.example.bangkit_2024_made.ReactiveProgramming.CoroutineFlow.network

import com.example.bangkit_2024_made.ReactiveProgramming.CoroutineFlow.model.PlaceResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("streets-v2")
    suspend fun getCountry(
        @Path("query") query: String,
        @Query("access_token") accessToken: String,
        @Query("autocomplete") autoComplete: Boolean = true
    ): PlaceResponse
}