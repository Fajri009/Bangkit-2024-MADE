package com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.domain.repository

import androidx.lifecycle.LiveData
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.data.Resource
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.domain.model.Tourism

interface ITourismRepository {
    fun getAllTourism(): LiveData<Resource<List<Tourism>>>
    fun getFavoriteTourism(): LiveData<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}