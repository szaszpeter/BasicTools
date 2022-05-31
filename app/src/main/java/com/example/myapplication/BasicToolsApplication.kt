package com.example.myapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@HiltAndroidApp
class BasicToolsApplication: Application() {
    val executorService: ExecutorService = Executors.newFixedThreadPool(4)
}