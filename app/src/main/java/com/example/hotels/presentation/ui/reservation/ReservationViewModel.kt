package com.example.hotels.presentation.ui.reservation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.hotels.domain.usecases.GetTouristDataUseCase
import com.example.hotels.presentation.ui.reservation.formatters.TouristFormatter
import com.example.hotels.presentation.ui.reservation.models.Tourist
import kotlinx.coroutines.launch

class ReservationViewModel(
    private val getTouristDataUseCase: GetTouristDataUseCase,
    private val formatter: TouristFormatter
) : ViewModel() {

    private val _dataLoading = MutableLiveData(true)
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _tourists = MutableLiveData<List<Tourist>>()
    val tourists = _tourists

    fun getData() {
        viewModelScope.launch {
            _dataLoading.postValue(true)

            val dataFlow = getTouristDataUseCase.execute()
            dataFlow.collect { list ->
                val vo = formatter.format(list)
                _tourists.postValue(vo)
                _dataLoading.postValue(false)
            }
        }
    }

    fun addTourist() {
        val cur = tourists.value
        val newList = cur?.let { ArrayList<Tourist>(it) }
        if (cur != null) {
            newList?.add(Tourist(cur.size + 1))
        }
        tourists.postValue(newList)
    }

    fun isValidSizeOfTourists(): Boolean {
        return (tourists.value?.size ?: 0) < 5
    }

    class ReservationViewModelFactory(
        private val getTouristDataUseCase: GetTouristDataUseCase,
        private val formatter: TouristFormatter
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ReservationViewModel (
                getTouristDataUseCase,
                formatter
            ) as T
        }
    }
}