package com.example.bangkit_2024_made.TourismAppProject.RxJava.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import com.example.bangkit_2024_made.TourismAppProject.RxJava.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().toLiveData()
}