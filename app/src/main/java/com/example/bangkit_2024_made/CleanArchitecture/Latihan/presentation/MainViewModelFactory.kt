package com.example.bangkit_2024_made.CleanArchitecture.Latihan.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bangkit_2024_made.CleanArchitecture.Latihan.di.Injection
import com.example.bangkit_2024_made.CleanArchitecture.Latihan.domain.MessageUseCase

// Kelas ini digunakan untuk menginisiasi ViewModel yang memiliki parameter
class MainViewModelFactory (
    private var messageUseCase: MessageUseCase
) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: MainViewModelFactory? = null

        fun getInstance(): MainViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: MainViewModelFactory(Injection.provideUseCase())
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(messageUseCase) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}