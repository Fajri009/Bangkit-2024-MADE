package com.example.bangkit_2024_made.TourismAppProject.Starter.core.domain.usecase

import com.example.bangkit_2024_made.TourismAppProject.Starter.core.domain.model.Tourism
import com.example.bangkit_2024_made.TourismAppProject.Starter.core.domain.repository.ITourismRepository

class TourismInteractor(private val tourismRepository: ITourismRepository): TourismUseCase {
    override fun getAllTourism() = tourismRepository.getAllTourism()
    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()
    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) = tourismRepository.setFavoriteTourism(tourism, state)
}