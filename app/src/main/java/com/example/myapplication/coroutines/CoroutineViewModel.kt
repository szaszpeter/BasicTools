package com.example.myapplication.coroutines

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class CoroutineViewModel(
    private val coroutineRepo: CoroutineSampleRepository,
    private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {

    /**  - - - - - - Launch Coroutine Example - - - - - - - - */

    fun launchSampleCoroutine() {
        // Create a new coroutine to move the execution off the UI thread
        viewModelScope.launch {
            performBasicNetworkRequest()
        }
    }


    /**  - - - - - - Async->Await Example - - - - - - - - */

    fun asyncAwaitSample() {
        viewModelScope.launch {
            coroutineScope {
                val deferredOne = async { performBasicNetworkRequest() }
                val deferredTwo = async { performBasicNetworkRequest() }
                deferredOne.await()
                deferredTwo.await()
            }
        }
    }


    /**  - - - - - - Async->AwaitAll Example - - - - - - - - */

    fun asyncAwaitAllSample() {
        viewModelScope.launch {
            coroutineScope {
                val deferreds = listOf(
                    async { performBasicNetworkRequest() },
                    async { performBasicNetworkRequest() }
                )
                deferreds.awaitAll()
            }
        }
    }


    /**  - - - - - - Custom Scope Example - - - - - - - - */

    val scope = CoroutineScope(Job() + Dispatchers.Main)

    fun customScopeMethod() {
        // Starts a new coroutine within the scope
        scope.launch {
            // New coroutine that can call suspend functions
            performBasicNetworkRequest()
        }
    }

    fun cleanUp() {
        // Cancel the scope to cancel ongoing coroutines work
        scope.cancel()
    }


    /**  - - - - - - Handle Job Example - - - - - - - - */

    val jobExampleScope = CoroutineScope(Job() + Dispatchers.Main)

    fun jobExampleMethod(cancel: Boolean) {
        // Handle to the coroutine, you can control its lifecycle
        val job = jobExampleScope.launch {
            performBasicNetworkRequest()
        }

        // Cancel the coroutine started above, this doesn't affect the scope
        // this coroutine was launched in
        if(cancel) {
            job.cancel()
        }
    }


    /**  - - - - - - Coroutine Context Example - - - - - - - - */

    val coroutineContextScope = CoroutineScope(Job() + Dispatchers.Main)

    fun coroutineContextExample() {
        // Starts a new coroutine on Dispatchers.Main as it's the scope's default
        val job1 = coroutineContextScope.launch {
            // New coroutine with CoroutineName = "coroutine" (default)
            performBasicNetworkRequest()
        }

        // Starts a new coroutine on Dispatchers.Default
        val job2 = coroutineContextScope.launch(Dispatchers.Default) {
            // New coroutine with overridden Dispatcher
            performBasicNetworkRequest()
        }
    }

    /**  - - - - - - Injected Dispatcher Example - - - - - - - - */

    fun injectedDispatcherExample() {
        // Starts a new coroutine on the injected dispatcher
        val job2 = coroutineContextScope.launch(defaultDispatcher) {
            // New coroutine with overridden Dispatcher
            performBasicNetworkRequest()
        }
    }


    suspend fun performBasicNetworkRequest() {
        val result = try {
            coroutineRepo.simpleCoroutineTest()
        } catch (e: Exception) {
            Result.Error(Exception("Network request failed"))
        }

        // Display result of the network request to the user
        when (result) {
            is Result.Success<String> -> Log.e("Result", result.data)
            else -> Log.e("Result", "Error")
        }
    }
}