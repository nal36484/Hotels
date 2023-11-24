package com.example.data.repositories.retrofitexample

import com.example.data.repositories.models.TouristNetWork
import kotlinx.coroutines.flow.Flow

interface ApiService {
    suspend fun getData(): Flow<List<TouristNetWork>>
}