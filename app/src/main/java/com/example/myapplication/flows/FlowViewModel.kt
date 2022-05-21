package com.example.myapplication.flows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class FlowViewModel(): ViewModel() {

    // Backing property to avoid state updates from other classes
    private val _uiState = MutableStateFlow(LatestUIState.Success(""))
    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<LatestUIState> = _uiState

    fun onTextChanged(text: String) {
        _uiState.value = LatestUIState.Success(text)
    }

}

// Represents different states for the LatestNews screen
sealed class LatestUIState {
    data class Success(val newText: String): LatestUIState()
    data class Error(val exception: Throwable): LatestUIState()
}