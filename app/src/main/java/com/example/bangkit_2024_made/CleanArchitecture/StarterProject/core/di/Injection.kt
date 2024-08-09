package com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.di

import android.content.Context
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.data.TourismRepository
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.data.source.local.LocalDataSource
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.data.source.local.room.TourismDatabase
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.data.source.remote.RemoteDataSource
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.data.source.remote.network.ApiConfig
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.domain.repository.ITourismRepository
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.domain.usecase.TourismInteractor
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.domain.usecase.TourismUseCase
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): ITourismRepository {
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTourismUseCase(context: Context): TourismUseCase {
        val repository = provideRepository(context)
        return TourismInteractor(repository)
    }
}