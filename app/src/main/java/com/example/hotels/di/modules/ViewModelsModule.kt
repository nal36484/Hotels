package com.example.hotels.di.modules

import com.example.hotels.presentation.ui.hotel.HotelViewModel
import com.example.hotels.presentation.ui.number.NumberViewModel
import com.example.hotels.presentation.ui.paid.PaidViewModel
import com.example.hotels.presentation.ui.reservation.ReservationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { HotelViewModel() }

    single { HotelViewModel.HotelViewModelFactory() }

    viewModel { NumberViewModel() }

    single { NumberViewModel.NumberViewModelFactory() }

    viewModel { ReservationViewModel(get(),get()) }

    single { ReservationViewModel.ReservationViewModelFactory(get(),get()) }

    viewModel { PaidViewModel() }

    single { PaidViewModel.PaidViewModelFactory() }
}