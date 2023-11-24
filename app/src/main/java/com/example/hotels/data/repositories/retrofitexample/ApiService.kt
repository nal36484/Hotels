package com.example.hotels.data.repositories.retrofitexample

import com.example.hotels.data.repositories.models.TouristNetWork
import kotlinx.coroutines.flow.Flow

interface ApiService {
    suspend fun getData(): Flow<List<TouristNetWork>>
}