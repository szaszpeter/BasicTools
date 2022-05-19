package com.example.myapplication.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRestClient {

    companion object {

        private val logInterceptor = HttpLoggingInterceptor()

        fun getService(): IApiService {

            logInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val httpClientBuilder = OkHttpClient.Builder()
            httpClientBuilder.addInterceptor(logInterceptor)

            val httpClient = httpClientBuilder.build()

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = Retrofit.Builder()
                .baseUrl(" https://httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build()

            return retrofit.create(IApiService::class.java)
        }
    }

}