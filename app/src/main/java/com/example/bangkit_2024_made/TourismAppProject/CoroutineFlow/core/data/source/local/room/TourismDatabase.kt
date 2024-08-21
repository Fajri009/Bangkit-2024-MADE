package com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.data.source.local.room

import android.content.Context
import androidx.room.*
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.data.source.local.entity.TourismEntity

@Database(entities = [TourismEntity::class], version = 1, exportSchema = false)
abstract class TourismDatabase : RoomDatabase() {
    abstract fun tourismDao(): TourismDao

    companion object {
        @Volatile
        private var INSTANCE: TourismDatabase? = null

        fun getInstance(context: Context): TourismDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TourismDatabase::class.java,
                    "Tourism.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
    }
}