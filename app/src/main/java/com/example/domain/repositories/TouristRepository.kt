package com.example.domain.repositories

import com.example.domain.model.TouristDto
import kotlinx.coroutines.flow.Flow

interface TouristRepository {
    suspend fun getData(): Flow<List<TouristDto>>
}