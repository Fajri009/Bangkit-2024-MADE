package com.example.bangkit_2024_made.TourismAppProject.Starter.core.data.source.local

import androidx.lifecycle.LiveData
import com.example.bangkit_2024_made.TourismAppProject.Starter.core.data.source.local.entity.TourismEntity
import com.example.bangkit_2024_made.TourismAppProject.Starter.core.data.source.local.room.TourismDao

class LocalDataSource private constructor(private val tourismDao: TourismDao) {
    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(tourismDao: TourismDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(tourismDao)
            }
    }

    fun getAllTourism(): LiveData<List<TourismEntity>> = tourismDao.getAllTourism()

    fun getFavoriteTourism(): LiveData<List<TourismEntity>> = tourismDao.getFavoriteTourism()

    fun insertTourism(tourismList: List<TourismEntity>) = tourismDao.insertTourism(tourismList)

    fun setFavoriteTourism(tourism: TourismEntity, newState: Boolean) {
        tourism.isFavorite = newState
        tourismDao.updateFavoriteTourism(tourism)
    }
}