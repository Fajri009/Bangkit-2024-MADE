package com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.data

import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.data.source.local.LocalDataSource
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.data.source.remote.RemoteDataSource
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.data.source.remote.network.ApiResponse
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.data.source.remote.response.TourismResponse
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.domain.model.Tourism
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.domain.repository.ITourismRepository
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.utils.AppExecutors
import com.example.bangkit_2024_made.TourismAppProject.CoroutineFlow.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

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

    override fun getAllTourism(): Flow<Resource<List<Tourism>>> =
        object : NetworkBoundResource<List<Tourism>, List<TourismResponse>>() {
            override fun loadFromDB(): Flow<List<Tourism>> {
                return localDataSource.getAllTourism().map { value ->
                    DataMapper.mapEntitiesToDomain(value)
                }
            }

            override fun shouldFetch(data: List<Tourism>?): Boolean =
//                data == null || data.isEmpty()
                true // ganti dengan true jika ingin selalu mengambil data dari internet

            override suspend fun createCall(): Flow<ApiResponse<List<TourismResponse>>> =
                remoteDataSource.getAllTourism()

            override suspend fun saveCallResult(data: List<TourismResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asFlow()

    override fun getFavoriteTourism(): Flow<List<Tourism>> {
        return localDataSource.getFavoriteTourism().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }
}