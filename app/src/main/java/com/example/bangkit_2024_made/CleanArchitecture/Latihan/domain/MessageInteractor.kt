package com.example.bangkit_2024_made.CleanArchitecture.Latihan.domain

// Kelas untuk Use Case
class MessageInteractor(private val messageRepository: IMessageRepository) : MessageUseCase {
    override fun getMessage(name: String): MessageEntity {
        return messageRepository.getWelcomeMessage(name)
    }
}