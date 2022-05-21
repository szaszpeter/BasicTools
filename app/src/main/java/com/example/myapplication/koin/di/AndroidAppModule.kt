package com.example.myapplication.koin.di

import kotlinx.coroutines.Dispatchers
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.example.myapplication")
class AndroidAppModule {

    @Single
    fun defaultDispatcher() = Dispatchers.Default
}
