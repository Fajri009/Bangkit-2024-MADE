package com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.di

import android.content.Context
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.data.TourismRepository
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.data.source.local.LocalDataSource
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.data.source.local.room.TourismDatabase
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.data.source.remote.RemoteDataSource
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.utils.AppExecutors
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): TourismRepository {
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}