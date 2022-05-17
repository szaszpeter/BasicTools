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
class LoginRepository() {
    private val loginUrl = "https://example.com/login"

    // Function that makes the network request, blocking the current thread
    suspend fun makeLoginRequest(
        jsonBody: String
    ): Result<String> {
        return withContext(Dispatchers.IO) {
            // Blocking network request code
            val url = URL(loginUrl)
            (url.openConnection() as? HttpURLConnection)?.run {
                requestMethod = "POST"
                setRequestProperty("Content-Type", "application/json; utf-8")
                setRequestProperty("Accept", "application/json")
                doOutput = true
                outputStream.write(jsonBody.toByteArray())
                return@run Result.Success("Success")
            }
            return@withContext Result.Error(Exception("Cannot open HttpURLConnection"))
        }

    }
}