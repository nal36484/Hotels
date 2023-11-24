package com.example.domain.usecases

import com.example.domain.model.TouristDto
import com.example.domain.repositories.TouristRepository
import kotlinx.coroutines.flow.Flow

class GetTouristDataUseCase(private val repository: TouristRepository) {
    suspend fun execute(): Flow<List<TouristDto>> {
        return repository.getData()
    }
}