package com.example.data.repositories.retrofitexample

import com.example.data.repositories.models.TouristNetWork
import com.example.data.repositories.retrofitexample.ApiService
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