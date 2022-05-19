package com.example.myapplication.retrofit

import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IApiService {

    @GET("get")
    fun test(): Call<Response<JSONObject>>

}
