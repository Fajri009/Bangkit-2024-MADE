package com.example.bangkit_2024_made.CleanArchitecture.Latihan.data

import com.example.bangkit_2024_made.CleanArchitecture.Latihan.domain.IMessageRepository

// Kelas ini akan mengatur datasource yang akan diberikan kepada Use Case
class MessageRepository(private val messageDataSource: IMessageDataSource) : IMessageRepository {
    override fun getWelcomeMessage(name: String) = messageDataSource.getMessageFromSource(name)
}