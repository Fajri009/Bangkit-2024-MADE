package com.example.bangkit_2024_made.TourismAppProject.Starter.core.domain.usecase

import androidx.lifecycle.LiveData
import com.example.bangkit_2024_made.TourismAppProject.Starter.core.data.Resource
import com.example.bangkit_2024_made.TourismAppProject.Starter.core.domain.model.Tourism

interface TourismUseCase {
    fun getAllTourism(): LiveData<Resource<List<Tourism>>>
    fun getFavoriteTourism(): LiveData<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}