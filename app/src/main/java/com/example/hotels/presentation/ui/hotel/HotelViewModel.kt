package com.example.hotels.presentation.ui.hotel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HotelViewModel : ViewModel() {

    fun getData() {

    }

    class HotelViewModelFactory : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HotelViewModel() as T
        }
    }
}