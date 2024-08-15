package com.example.bangkit_2024_made.TourismAppProject.Starter.favorite

import androidx.lifecycle.*
import com.example.bangkit_2024_made.TourismAppProject.Starter.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val favoriteTourism = tourismUseCase.getFavoriteTourism()
}