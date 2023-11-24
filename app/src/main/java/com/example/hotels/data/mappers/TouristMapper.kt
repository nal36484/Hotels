package com.example.hotels.data.mappers

import com.example.hotels.data.repositories.models.TouristNetWork
import com.example.hotels.domain.model.TouristDto

class TouristMapper {
    fun map(dto: List<TouristNetWork>): List<TouristDto> {
        return dto.mapNotNull { data ->
            if (data.id != null) {
                TouristDto(
                    id = data.id,
                    name = data.name,
                    surname = data.surname,
                    data = data.data,
                    citizen = data.citizen,
                    passport = data.passport,
                    period = data.period
                )
            } else {
                null
            }
        }
    }
}