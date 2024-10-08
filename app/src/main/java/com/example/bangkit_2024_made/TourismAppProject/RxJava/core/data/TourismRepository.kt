package com.example.bangkit_2024_made.TourismAppProject.RxJava.core.data

import com.example.bangkit_2024_made.TourismAppProject.RxJava.core.data.source.local.LocalDataSource
import com.example.bangkit_2024_made.TourismAppProject.RxJava.core.data.source.remote.RemoteDataSource
import com.example.bangkit_2024_made.TourismAppProject.RxJava.core.data.source.remote.network.ApiResponse
import com.example.bangkit_2024_made.TourismAppProject.RxJava.core.data.source.remote.response.TourismResponse
import com.example.bangkit_2024_made.TourismAppProject.RxJava.core.domain.model.Tourism
import com.example.bangkit_2024_made.TourismAppProject.RxJava.core.domain.repository.ITourismRepository
import com.example.bangkit_2024_made.TourismAppProject.RxJava.core.utils.AppExecutors
import com.example.bangkit_2024_made.TourismAppProject.RxJava.core.utils.DataMapper
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TourismRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): ITourismRepository {
    companion object {
        @Volatile
        private var instance: TourismRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): TourismRepository =
            instance ?: synchronized(this) {
                instance ?: TourismRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllTourism(): Flowable<Resource<List<Tourism>>> =
        object : NetworkBoundResource<List<Tourism>, List<TourismResponse>>() {
            override fun loadFromDB(): Flowable<List<Tourism>> {
                return localDataSource.getAllTourism().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Tourism>?): Boolean =
                true // nilai kembalian true supaya selalu mengambil data dari internet

            override fun createCall(): Flowable<ApiResponse<List<TourismResponse>>> =
                remoteDataSource.getAllTourism()

            override fun saveCallResult(data: List<TourismResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()

    override fun getFavoriteTourism(): Flowable<List<Tourism>> {
        return localDataSource.getFavoriteTourism().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism) // untuk mengubah Domain Model menjadi Entity Model (Room)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }
}