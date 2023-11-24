package com.example.hotels.presentation.ui.reservation.formatters

import com.example.hotels.domain.model.TouristDto
import com.example.hotels.presentation.ui.reservation.models.Tourist

class TouristFormatter {
    fun format(data: List<TouristDto>): List<Tourist> {
        return data.map { tourist ->
            Tourist(
                id = tourist.id,
                name = tourist.name,
                surname = tourist.surname,
                data = tourist.data,
                citizen = tourist.citizen,
                passport = tourist.passport,
                period = tourist.period
            )
        }
    }
}