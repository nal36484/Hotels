package com.example.hotels.data.repositories.retrofitexample

import com.example.hotels.data.repositories.models.TouristNetWork
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiServiceImpl() : ApiService {
    override suspend fun getData(): Flow<List<TouristNetWork>> {
        val list = listOf(
            TouristNetWork(1,"Иван", "Иванов"),
        )
        return flow { emit(list) }

    }

}