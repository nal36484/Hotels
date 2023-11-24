package com.example.hotels.data.repositories

import com.example.hotels.domain.model.TouristDto
import com.example.hotels.domain.repositories.TouristRepository
import kotlinx.coroutines.flow.Flow

class TouristRepositoryImpl(
    private val networkDataSource: NetworkDataSource
) : TouristRepository {
    override suspend fun getData(): Flow<List<TouristDto>> {
        return networkDataSource.getNetworkData()
    }
}