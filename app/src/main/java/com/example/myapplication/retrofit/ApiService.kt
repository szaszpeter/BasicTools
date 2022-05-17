package com.example.myapplication.retrofit

import org.koin.core.annotation.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Single
class ApiService {
    fun testCall() {
        return RetrofitRestClient.getService().test("Test")
            .enqueue(object : Callback<Response<String>> {
                override fun onResponse(
                    call: Call<Response<String>>,
                    response: Response<Response<String>>
                ) {
                    // write code here
                }

                override fun onFailure(call: Call<Response<String>>, t: Throwable) {
                    // write code here
                }

            })

    }
}