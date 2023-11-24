package com.example.hotels.di.modules

import com.example.data.mappers.TouristMapper
import com.example.data.repositories.NetworkDataSource
import com.example.data.repositories.NetworkDataSourceImpl
import com.example.data.repositories.TouristRepositoryImpl
import com.example.data.repositories.retrofitexample.ApiService
import com.example.data.repositories.retrofitexample.ApiServiceImpl
import com.example.domain.repositories.TouristRepository
import com.example.domain.usecases.GetTouristDataUseCase
import com.example.hotels.presentation.ui.reservation.formatters.TouristFormatter
import org.koin.dsl.module
import kotlin.math.sin

val repositoryModule = module {
    single<TouristRepository> { TouristRepositoryImpl(get()) }

    single<NetworkDataSource> { NetworkDataSourceImpl(get(),get()) }

    factory { TouristMapper() }

    single<ApiService> { ApiServiceImpl() }

    single { GetTouristDataUseCase(get()) }

    single { TouristFormatter() }
}