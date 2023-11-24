package com.example.hotels.data.repositories

import com.example.hotels.data.mappers.TouristMapper
import com.example.hotels.data.repositories.retrofitexample.ApiService
import com.example.hotels.domain.model.TouristDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NetworkDataSourceImpl(
    private val api: ApiService,
    private val mapper: TouristMapper
) : NetworkDataSource {
    override suspend fun getNetworkData(): Flow<List<TouristDto>> {
        val dataFlow = api.getData()
        return dataFlow.map { list ->
            mapper.map(list)
        }
    }
}