package com.example.myapplication.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Single
import java.net.HttpURLConnection
import java.net.URL

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

@Single
class CoroutineSampleRepository() {
    private val testUrl = "https://reqres.in/api/unknown/2"

    // Function that makes the network request, blocking the current thread
    suspend fun simpleCoroutineTest(
    ): Result<String> {
        return withContext(Dispatchers.IO) {
            // Blocking network request code
            val url = URL(testUrl)
            (url.openConnection() as? HttpURLConnection)?.run {
                requestMethod = "GET"
                setRequestProperty("Content-Type", "application/json; utf-8")
                setRequestProperty("Accept", "application/json")
                doOutput = true
                val inputAsString = inputStream.bufferedReader().use { it.readText() }
                return@withContext Result.Success(inputAsString)
            }
            return@withContext Result.Error(Exception("Cannot open HttpURLConnection"))
        }
    }
}