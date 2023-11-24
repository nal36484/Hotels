package com.example.hotels.presentation.ui.number

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NumberViewModel : ViewModel() {

    fun getData() {

    }

    class NumberViewModelFactory : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return NumberViewModel () as T
        }
    }
}