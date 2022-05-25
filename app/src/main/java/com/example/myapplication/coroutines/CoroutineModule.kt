package com.example.myapplication.coroutines

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class CoroutineModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class DispatcherDefault


    @DispatcherDefault
    @Singleton
    @Provides
    fun provideCoroutineDefaultDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }

}