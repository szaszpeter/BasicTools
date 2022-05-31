package com.example.myapplication.threadpool

import com.example.myapplication.BasicToolsApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ThreadPoolModule {

    @Singleton
    @Provides
    fun provideExecutor(): Executor {
        return Executors.newFixedThreadPool(4)
    }
}