package com.example.bangkit_2024_made.TourismAppProject.RxJava.core.domain.repository

import com.example.bangkit_2024_made.TourismAppProject.RxJava.core.data.Resource
import com.example.bangkit_2024_made.TourismAppProject.RxJava.core.domain.model.Tourism
import io.reactivex.Flowable

interface ITourismRepository {
    fun getAllTourism(): Flowable<Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flowable<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}