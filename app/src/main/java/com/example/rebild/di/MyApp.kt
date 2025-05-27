package com.example.rebild.di

import android.app.Application
import com.example.core_network_impl.NetworkComponentImpl

class MyApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        val networkComponent = NetworkComponentImpl.initAndGet()

        appComponent = DaggerAppComponent.factory().create(this, networkComponent)
    }
}
