package com.example.bangkit_2024_made.CleanArchitecture.StarterProject.detail

import androidx.lifecycle.ViewModel
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.data.TourismRepository
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.data.source.local.entity.TourismEntity

class DetailTourismViewModel(private val tourismRepository: TourismRepository) : ViewModel() {
    fun setFavoriteTourism(tourism: TourismEntity, newStatus:Boolean) = tourismRepository.setFavoriteTourism(tourism, newStatus)
}