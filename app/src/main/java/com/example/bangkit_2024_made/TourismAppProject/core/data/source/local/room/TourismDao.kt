package com.example.bangkit_2024_made.TourismAppProject.core.data.source.local.room

import androidx.room.*
import com.example.bangkit_2024_made.TourismAppProject.core.data.source.local.entity.TourismEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface TourismDao {
    @Query("SELECT * FROM tourism")
    fun getAllTourism(): Flowable<List<TourismEntity>>

    @Query("SELECT * FROM tourism where isFavorite = 1")
    fun getFavoriteTourism(): Flowable<List<TourismEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTourism(tourism: List<TourismEntity>): Completable

    @Update
    fun updateFavoriteTourism(tourism: TourismEntity)
}