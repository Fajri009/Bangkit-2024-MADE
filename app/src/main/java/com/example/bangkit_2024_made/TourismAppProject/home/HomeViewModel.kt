package com.example.bangkit_2024_made.TourismAppProject.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import com.example.bangkit_2024_made.TourismAppProject.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().toLiveData()
}