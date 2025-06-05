package com.example.feature_products_api.di

import com.example.core_common.ComponentInjector
import com.example.core_database_api.ProductDao
import com.example.core_network_api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

interface ProductsFeatureDeps {
    fun productDao(): ProductDao
    fun provideLoggingInterceptor(): HttpLoggingInterceptor
    fun apiService(): ApiService
    fun okHttpClient(): OkHttpClient
    fun productsNavigationApi(): ProductsNavigationApi
    fun componentInjector(): ComponentInjector
}