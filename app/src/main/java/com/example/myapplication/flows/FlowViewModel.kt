package com.example.myapplication.flows

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FlowViewModel @Inject constructor(): ViewModel() {

    // Backing property to avoid state updates from other classes
    private val _uiState = MutableStateFlow(LatestUIState.Success(""))
    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<LatestUIState> = _uiState

    fun onTextChanged(text: String) {
        //In this example I will simultaneously capture the text and apply a minimal transformation to it
        _uiState.value = LatestUIState.Success(text.uppercase(Locale.ROOT))
    }

}

// Represents different states for the LatestNews screen
sealed class LatestUIState {
    data class Success(val newText: String): LatestUIState()
    data class Error(val exception: Throwable): LatestUIState()
}