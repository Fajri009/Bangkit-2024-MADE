package com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.data.TourismRepository
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.core.di.Injection
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.detail.DetailTourismViewModel
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.favorite.FavoriteViewModel
import com.example.bangkit_2024_made.CleanArchitecture.StarterProject.home.HomeViewModel

class ViewModelFactory private constructor(private val tourismRepository: TourismRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance
                ?: synchronized(this) {
                    instance
                        ?: ViewModelFactory(
                            Injection.provideRepository(
                                context
                            )
                        )
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(tourismRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(tourismRepository) as T
            }
            modelClass.isAssignableFrom(DetailTourismViewModel::class.java) -> {
                DetailTourismViewModel(tourismRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}