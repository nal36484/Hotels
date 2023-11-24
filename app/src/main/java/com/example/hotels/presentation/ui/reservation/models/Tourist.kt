package com.example.hotels.presentation.ui.reservation.models

//don't need to use some default values
data class Tourist(
    val id: Int,
    val name: String = "",
    val surname: String = "",
    val data: String = "",
    val citizen: String = "",
    val passport: String = "",
    val period: String = ""
)
