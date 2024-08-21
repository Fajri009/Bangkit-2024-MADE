package com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.detail

import androidx.lifecycle.ViewModel
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.domain.model.Tourism
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) =
        tourismUseCase.setFavoriteTourism(tourism, newStatus)
}