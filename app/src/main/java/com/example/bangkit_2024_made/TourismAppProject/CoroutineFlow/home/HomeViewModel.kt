package com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}