package com.example.bangkit_2024_made.CleanArchitecture.Latihan.di

import com.example.bangkit_2024_made.CleanArchitecture.Latihan.data.IMessageDataSource
import com.example.bangkit_2024_made.CleanArchitecture.Latihan.data.MessageDataSource
import com.example.bangkit_2024_made.CleanArchitecture.Latihan.data.MessageRepository
import com.example.bangkit_2024_made.CleanArchitecture.Latihan.domain.IMessageRepository
import com.example.bangkit_2024_made.CleanArchitecture.Latihan.domain.MessageInteractor
import com.example.bangkit_2024_made.CleanArchitecture.Latihan.domain.MessageUseCase

object Injection {
    fun provideUseCase(): MessageUseCase {
        val messageRepository = provideRepository()
        return MessageInteractor(messageRepository)
    }

    private fun provideRepository(): IMessageRepository {
        val messageDataSource = provideDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideDataSource(): IMessageDataSource {
        return MessageDataSource()
    }
}