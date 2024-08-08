package com.example.bangkit_2024_made.CleanArchitecture.StarterProject.favorite

import androidx.lifecycle.ViewModel
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.data.TourismRepository

class FavoriteViewModel(tourismRepository: TourismRepository) : ViewModel() {
    val favoriteTourism = tourismRepository.getFavoriteTourism()
}