package com.example.bangkit_2024_made.DependencyInjection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

// untuk mengimplementasikan Koin di semua kelas yang extend ke Application
open class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin { // untuk membuat Koin melakukan injection di semua turunan application, seperti Activity dan Fragment
            androidContext(this@MyApplication) // untuk mem-provide fungsi yang membutuhkan context
            modules(storageModule) // untuk menambahkan module di dalam Koin
        }
    }
}