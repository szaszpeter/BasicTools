package com.example.myapplication.koin.presenter

import com.example.myapplication.HelloRepository
import org.koin.core.annotation.Factory

@Factory
class MySimplePresenter(val repo: HelloRepository) {

    fun sayHello() = "${repo.hello()} from $this"
}