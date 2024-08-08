package com.example.bangkit_2024_made.CleanArchitecture.Latihan.data

import com.example.bangkit_2024_made.CleanArchitecture.Latihan.domain.MessageEntity

// Datasource yang merupakan template untuk implementation nanti
interface IMessageDataSource {
    fun getMessageFromSource(name: String): MessageEntity
}