package com.example.bangkit_2024_made.TourismAppProject.core.di

import android.content.Context
import com.example.bangkit_2024_made.TourismAppProject.core.data.TourismRepository
import com.example.bangkit_2024_made.TourismAppProject.core.data.source.local.LocalDataSource
import com.example.bangkit_2024_made.TourismAppProject.core.data.source.local.room.TourismDatabase
import com.example.bangkit_2024_made.TourismAppProject.core.data.source.remote.network.ApiConfig
import com.example.bangkit_2024_made.TourismAppProject.core.domain.repository.ITourismRepository
import com.example.bangkit_2024_made.TourismAppProject.core.domain.usecase.TourismInteractor
import com.example.bangkit_2024_made.TourismAppProject.core.domain.usecase.TourismUseCase
import com.example.bangkit_2024_made.TourismAppProject.core.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): ITourismRepository {
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = com.example.bangkit_2024_made.TourismAppProject.core.data.source.remote.RemoteDataSource.getInstance(
            ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTourismUseCase(context: Context): TourismUseCase {
        val repository = provideRepository(context)
        return TourismInteractor(repository)
    }
}