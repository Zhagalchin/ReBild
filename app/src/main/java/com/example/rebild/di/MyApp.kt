package com.example.rebild.di

import android.app.Application

class MyApp : Application() {
    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
}