package com.example.rebild.di

import android.app.Application
import com.example.core_common.ComponentInjector
import com.example.core_database_impl.DatabaseComponentImpl
import com.example.core_network_impl.NetworkComponentImpl

class MyApp : Application() {
    lateinit var appComponent: AppComponent

    val componentInjector: ComponentInjector
        get() = appComponent.componentInjector()

    override fun onCreate() {
        super.onCreate()
        val networkComponent = NetworkComponentImpl.initAndGet()
        val databaseComponent = DatabaseComponentImpl.getAndInit(this)

        appComponent = DaggerAppComponent.factory().create(this, networkComponent, databaseComponent)
    }
}
