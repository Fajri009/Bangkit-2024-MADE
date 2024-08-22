package com.example.bangkit_2024_made.DependencyInjection

import org.koin.dsl.module

// untuk menyiapkan inisialisasi SessionManager
val storageModule = module {
    factory {
        SessionManager(get())
    }

    factory {
        UserRepository(get())
    }
}