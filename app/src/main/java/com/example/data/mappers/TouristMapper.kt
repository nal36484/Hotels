package com.example.data.mappers

import com.example.data.repositories.models.TouristNetWork
import com.example.domain.model.TouristDto

class TouristMapper {
    fun map(data: List<TouristNetWork>): List<TouristDto> {
        return data.mapNotNull { data ->
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