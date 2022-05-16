package com.example.myapplication

import org.koin.core.annotation.Single


interface HelloRepository {
    fun hello(): String
}

/**
 * Hello Service Impl
 * Will use HelloMessageData data
 */

@Single
class HelloRepositoryImpl() : HelloRepository {
    override fun hello() = "Hey, Koin"
}