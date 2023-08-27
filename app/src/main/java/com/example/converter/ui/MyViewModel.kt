package com.example.converter.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// step 3

data class ConverterState(
    val userData: String = "",
    val result: String = "",
    val isFahrenhiet: Boolean = false
)

// step 2
class MyViewModel : ViewModel() {
    //    step 4
    private val _uiState = MutableStateFlow(ConverterState())
    val uiState: StateFlow<ConverterState> = _uiState;

    //    step 5
   private fun convertTemperature() {
//    step 6
        val number = _uiState.value.userData.toInt()

        val result = if (_uiState.value.isFahrenhiet) {
            //        Covert to Celsius
            "${(number - 32) * 5 / 9} °F"
        } else {
            //        convert to farhenheit
            "${(number * 9 / 5) + 32} °C"
        }
// step 7 - update the state
        _uiState.value = _uiState.value.copy(result = result.toString())
    }

    //    step 8
    fun updateSwitchState(isFahrenhiet: Boolean) {
        _uiState.value = _uiState.value.copy(isFahrenhiet = isFahrenhiet)
    }

    //    step 9
    fun onUserSubmit() {
        convertTemperature()
    }

    fun onTextChange(userData: String) {
        _uiState.value = _uiState.value.copy(userData = userData)
    }
}