package com.example.bangkit_2024_made.TourismAppProject.RxJava.favorite

import androidx.lifecycle.*
import com.example.bangkit_2024_made.TourismAppProject.RxJava.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val favoriteTourism = tourismUseCase.getFavoriteTourism().toLiveData()
}