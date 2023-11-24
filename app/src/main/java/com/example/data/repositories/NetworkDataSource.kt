package com.example.data.repositories

import com.example.domain.model.TouristDto
import kotlinx.coroutines.flow.Flow

interface NetworkDataSource {
    suspend fun getNetworkData(): Flow<List<TouristDto>>
}