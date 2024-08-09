package com.example.bangkit_2024_made.CleanArchitecture.StarterProject.home

import androidx.lifecycle.ViewModel
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism()
}