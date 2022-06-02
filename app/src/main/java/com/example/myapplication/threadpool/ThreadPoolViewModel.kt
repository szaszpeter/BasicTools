package com.example.myapplication.threadpool

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThreadPoolViewModel @Inject constructor(
    private val threadPoolSampleRepository: ThreadPoolSampleRepository
): ViewModel() {

    fun makeTestRequest() {
        threadPoolSampleRepository.makeAsyncRequest {result ->
            when(result) {
                is Result.Success<String> -> Log.e("Result Success", result.data)
                is Result.Error -> Log.e("Result Failure", result.exception.toString())
            }
        }
    }
}

