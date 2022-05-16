package com.example.myapplication.koin.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.HelloRepository
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MyViewModel(val repo : HelloRepository) : ViewModel() {

    fun sayHello() = "${repo.hello()} from $this"
}