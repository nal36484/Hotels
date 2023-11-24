package com.example.hotels.domain.repositories

import com.example.hotels.domain.model.TouristDto
import kotlinx.coroutines.flow.Flow

interface TouristRepository {
    suspend fun getData(): Flow<List<TouristDto>>
}