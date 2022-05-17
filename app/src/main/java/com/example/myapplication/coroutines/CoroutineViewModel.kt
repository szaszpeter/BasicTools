package com.example.myapplication.coroutines

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class CoroutineViewModel(
    private val loginRepository: LoginRepository
) : ViewModel() {

    fun launchSampleCoroutine(username: String, token: String) {

        // Create a new coroutine to move the execution off the UI thread
        viewModelScope.launch {

            Log.e("Couroutine", " Launching")

            val jsonBody = "{ username: \"$username\", token: \"$token\"}"

            // Make the network call and suspend execution until it finishes
            val result = try {
                loginRepository.makeLoginRequest(jsonBody)
            } catch(e: Exception) {
                Result.Error(Exception("Network request failed"))
            }

            // Display result of the network request to the user
            when (result) {
                is Result.Success<String> -> Log.e("Result", "Success")
                else -> Log.e("Result", "Error")
            }
        }
    }
}