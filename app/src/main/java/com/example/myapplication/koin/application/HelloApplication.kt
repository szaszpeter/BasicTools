package com.example.myapplication.koin.application

import android.app.Application
import com.example.myapplication.koin.di.AndroidAppModule
import org.koin.core.context.GlobalContext.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.ksp.generated.module

/**
 * HelloApplication - Application Class
 * use HelloService
 */

class HelloApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // start Koin context
        startKoin {
            androidContext(this@HelloApplication)
            androidLogger()
            modules(AndroidAppModule().module)
        }
    }
}