package com.example.hotels.di.modules

import com.example.hotels.data.mappers.TouristMapper
import com.example.hotels.data.repositories.NetworkDataSource
import com.example.hotels.data.repositories.NetworkDataSourceImpl
import com.example.hotels.data.repositories.TouristRepositoryImpl
import com.example.hotels.data.repositories.retrofitexample.ApiService
import com.example.hotels.data.repositories.retrofitexample.ApiServiceImpl
import com.example.hotels.domain.repositories.TouristRepository
import com.example.hotels.domain.usecases.GetTouristDataUseCase
import com.example.hotels.presentation.ui.reservation.formatters.TouristFormatter
import org.koin.dsl.module

val repositoryModule = module {
    single<TouristRepository> { TouristRepositoryImpl(get()) }

    single<NetworkDataSource> { NetworkDataSourceImpl(get(),get()) }

    factory { TouristMapper() }

    single<ApiService> { ApiServiceImpl() }

    single { GetTouristDataUseCase(get()) }

    single { TouristFormatter() }
}