package com.example.feature_cart_api

import com.example.core_database_api.ProductDao
import com.example.core_network_api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

interface CartFeatureDeps {
    fun productDao(): ProductDao
    fun provideLoggingInterceptor(): HttpLoggingInterceptor
    fun apiService(): ApiService
    fun okHttpClient(): OkHttpClient
}