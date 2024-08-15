package com.example.bangkit_2024_made.TourismAppProject.RxJava.core.data.source.remote.network

import com.example.bangkit_2024_made.TourismAppProject.RxJava.core.data.source.remote.response.ListTourismResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService {
    @GET("list")
    fun getList(): Flowable<ListTourismResponse>
}