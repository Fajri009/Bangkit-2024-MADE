package com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.domain.repository

import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.data.Resource
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface ITourismRepository {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flow<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}