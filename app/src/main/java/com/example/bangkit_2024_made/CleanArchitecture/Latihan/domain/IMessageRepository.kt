package com.example.bangkit_2024_made.CleanArchitecture.Latihan.domain

// Kelas ini berisi proses bisnis yang akan dipanggil dari Use Case
interface IMessageRepository {
    fun getWelcomeMessage(name: String): MessageEntity
}