package com.example.bangkit_2024_made.CleanArchitecture.Latihan.data

import com.example.bangkit_2024_made.CleanArchitecture.Latihan.domain.MessageEntity

// Sumber data message yang akan didapat
class MessageDataSource : IMessageDataSource {
    override fun getMessageFromSource(name: String) = MessageEntity("Hello $name! Welcome to Clean Architecture")
}