package com.example.hotels.data.repositories

import com.example.hotels.domain.model.TouristDto
import kotlinx.coroutines.flow.Flow

interface NetworkDataSource {
    suspend fun getNetworkData(): Flow<List<TouristDto>>
}