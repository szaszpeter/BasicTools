package com.example.myapplication.hilt

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import okhttp3.OkHttpClient
import javax.inject.Inject


// As a dependency of a constructor-injected class.
@ActivityScoped
class ExampleServiceImpl @Inject constructor(
    @NetworkModule.AuthInterceptorOkHttpClient private val okHttpClient: OkHttpClient,
    @ActivityContext private val context: Context,
)