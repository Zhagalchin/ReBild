package com.example.core_common

import android.app.Application

interface ComponentInjector {
    fun createProductsComponent(application: Application)
    fun createCartComponent(application: Application)
    fun createPDPComponent(application: Application)
}