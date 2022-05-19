package com.example.myapplication.retrofit

import org.json.JSONObject
import org.koin.core.annotation.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Single
class ApiService {
    fun testCall() {
        return RetrofitRestClient.getService().test()
            .enqueue(object : Callback<Response<JSONObject>> {
                override fun onResponse(
                    call: Call<Response<JSONObject>>,
                    response: Response<Response<JSONObject>>
                ) {

                }

                override fun onFailure(call: Call<Response<JSONObject>>, t: Throwable) {

                }

            })

    }
}