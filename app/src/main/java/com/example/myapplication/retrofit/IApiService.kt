package com.example.myapplication.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IApiService {

    @POST("enterEndpoint.here")
    fun test(@Body stub: String): Call<Response<String>>

}
