package com.example.hotels.presentation.ui.paid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PaidViewModel : ViewModel() {

    fun getData() {

    }

    class PaidViewModelFactory : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return PaidViewModel () as T
        }
    }
}