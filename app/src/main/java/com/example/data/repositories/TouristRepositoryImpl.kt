package com.example.data.repositories

import com.example.domain.model.TouristDto
import com.example.domain.repositories.TouristRepository
import kotlinx.coroutines.flow.Flow

class TouristRepositoryImpl(
    private val networkDataSource: NetworkDataSource
) : TouristRepository {
    override suspend fun getData(): Flow<List<TouristDto>> {
        return networkDataSource.getNetworkData()
    }
}