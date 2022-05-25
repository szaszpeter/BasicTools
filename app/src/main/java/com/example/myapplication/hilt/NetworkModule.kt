package com.example.myapplication.hilt

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class AuthInterceptorOkHttpClient

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class OtherInterceptorOkHttpClient

//    @AuthInterceptorOkHttpClient
//    @Provides
//    fun provideAuthInterceptorOkHttpClient(
//        authInterceptor: AuthInterceptor
//    ): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(authInterceptor)
//            .build()
//    }
//
//    @OtherInterceptorOkHttpClient
//    @Provides
//    fun provideOtherInterceptorOkHttpClient(
//        otherInterceptor: OtherInterceptor
//    ): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(otherInterceptor)
//            .build()
//    }
}

