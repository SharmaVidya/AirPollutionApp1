package com.learning.airpollutionapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.airpollutionapp.network.AirApi
import com.learning.airpollutionapp.network.AirResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}

data class AirState(
    val result:AirResponse = AirResponse(),
    val status: Status = Status.LOADING,
    val error: String = "",
)

class AirViewModel() : ViewModel() {

    private val _state = MutableStateFlow(AirState())
    val state = _state.asStateFlow()

    init {
        fetchAirData()
    }

    private fun fetchAirData() {
        viewModelScope.launch {
            try {
                val result = AirApi.retrofitService.getAirData(
                    lat = 26.50,
                    lon = 80.80,
                    apiKey = "6268c2e1d6f4c5150dcf77feb727b6f8"
                )
                _state.update { it.copy(result = result, status = Status.SUCCESS) }
            } catch (e: Exception) {
                _state.update {
                    it.copy(status = Status.ERROR, error = e.message?:"Error,Loading the information!")
                }
            }
        }
    }
}
