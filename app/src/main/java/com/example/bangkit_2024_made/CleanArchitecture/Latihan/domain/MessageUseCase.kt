package com.example.bangkit_2024_made.CleanArchitecture.Latihan.domain

// Kelas yang akan menjadi basis dari semua Use Case
interface MessageUseCase {
    fun getMessage(name: String): MessageEntity
}