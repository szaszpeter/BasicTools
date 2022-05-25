package com.example.myapplication.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AnalyticsModule {

    @Singleton
    @Binds
    abstract fun bindAnalyticsService(
        analyticsServiceImpl: AnalyticsServiceImpl
    ): AnalyticsService

//    @Singleton
//    @Provides
//    fun provideAnalyticsService(
//        // Potential dependencies of this type
//    ): AnalyticsService {
//        return Retrofit.Builder()
//            .baseUrl("https://example.com")
//            .build()
//            .create(AnalyticsService::class.java)
//    }
//
//    @Provides
//    fun provideAnalyticsService(
//        @NetworkModule.AuthInterceptorOkHttpClient okHttpClient: OkHttpClient
//    ): AnalyticsService {
//        return Retrofit.Builder()
//            .baseUrl("https://example.com")
//            .client(okHttpClient)
//            .build()
//            .create(AnalyticsService::class.java)
//    }
}