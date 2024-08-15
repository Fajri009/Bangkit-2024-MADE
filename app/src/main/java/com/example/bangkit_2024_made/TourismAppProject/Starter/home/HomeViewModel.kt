package com.example.bangkit_2024_made.TourismAppProject.Starter.home

import androidx.lifecycle.ViewModel
import com.example.bangkit_2024_made.TourismAppProject.Starter.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism()
}