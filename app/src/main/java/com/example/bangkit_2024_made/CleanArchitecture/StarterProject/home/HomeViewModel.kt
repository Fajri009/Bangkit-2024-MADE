package com.example.bangkit_2024_made.CleanArchitecture.StarterProject.home

import androidx.lifecycle.ViewModel
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.data.TourismRepository

class HomeViewModel(tourismRepository: TourismRepository) : ViewModel() {
    val tourism = tourismRepository.getAllTourism()
}