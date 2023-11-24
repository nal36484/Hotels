package com.example.hotels.domain.usecases

import com.example.hotels.domain.model.TouristDto
import com.example.hotels.domain.repositories.TouristRepository
import kotlinx.coroutines.flow.Flow

class GetTouristDataUseCase(private val repository: TouristRepository) {
    suspend fun execute(): Flow<List<TouristDto>> {
        return repository.getData()
    }
}