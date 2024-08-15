package com.example.bangkit_2024_made.TourismAppProject.Starter.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.bangkit_2024_made.TourismAppProject.Starter.core.data.source.local.entity.TourismEntity
import io.reactivex.Completable

@Dao
interface TourismDao {
    @Query("SELECT * FROM tourism")
    fun getAllTourism(): LiveData<List<TourismEntity>>

    @Query("SELECT * FROM tourism where isFavorite = 1")
    fun getFavoriteTourism(): LiveData<List<TourismEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTourism(tourism: List<TourismEntity>): Completable

    @Update
    fun updateFavoriteTourism(tourism: TourismEntity)
}