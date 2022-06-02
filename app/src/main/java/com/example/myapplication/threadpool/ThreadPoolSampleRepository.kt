package com.example.myapplication.threadpool

import android.util.Log
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThreadPoolSampleRepository @Inject constructor(
    private val executor: Executor
) {
    private val testUrl = "https://reqres.in/api/unknown/2"

    fun makeAsyncRequest(callback: (Result<String>) -> Unit) {
        executor.execute {
            makeTestRequest(callback)
        }
    }

    // Function that makes the network request, blocking the current thread
    fun makeTestRequest(callback: (Result<String>) -> Unit) {
        // Blocking network request code
        try {
            val url = URL(testUrl)
            (url.openConnection() as? HttpURLConnection)?.run {
                requestMethod = "GET"
                setRequestProperty("Content-Type", "application/json; utf-8")
                setRequestProperty("Accept", "application/json")
                doOutput = true
                val inputAsString = inputStream.bufferedReader().use { it.readText() }
                Log.e("Response: ", inputAsString)
                callback(Result.Success(inputAsString))
            }
        } catch (e: Exception) {
            val errorResult = Result.Error(e)
            callback(errorResult)
        }
    }
}

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}