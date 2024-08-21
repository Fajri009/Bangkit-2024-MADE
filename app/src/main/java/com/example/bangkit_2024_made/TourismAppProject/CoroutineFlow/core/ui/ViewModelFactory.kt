package com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.di.Injection
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.domain.usecase.TourismUseCase
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.detail.DetailTourismViewModel
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.favorite.FavoriteViewModel
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.home.HomeViewModel

class ViewModelFactory private constructor(private val tourismUseCase: TourismUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance
                ?: synchronized(this) {
                    instance
                        ?: ViewModelFactory(
                            Injection.provideTourismUseCase(
                                context
                            )
                        )
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(tourismUseCase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(tourismUseCase) as T
            }
            modelClass.isAssignableFrom(DetailTourismViewModel::class.java) -> {
                DetailTourismViewModel(
                    tourismUseCase
                ) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}