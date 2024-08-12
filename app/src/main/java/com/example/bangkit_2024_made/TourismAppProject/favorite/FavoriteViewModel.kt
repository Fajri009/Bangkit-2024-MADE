package com.example.bangkit_2024_made.TourismAppProject.favorite

import androidx.lifecycle.*
import com.example.bangkit_2024_made.TourismAppProject.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val favoriteTourism = tourismUseCase.getFavoriteTourism().toLiveData()
}