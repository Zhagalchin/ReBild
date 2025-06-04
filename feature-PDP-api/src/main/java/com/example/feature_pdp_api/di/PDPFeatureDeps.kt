package com.example.feature_pdp_api.di

import com.example.core_database_api.ProductDao
import com.example.core_network_api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

interface PDPFeatureDeps {
    fun productDao(): ProductDao
    fun provideLoggingInterceptor(): HttpLoggingInterceptor
    fun apiService(): ApiService
    fun okHttpClient(): OkHttpClient
//    fun productsNavigationApi(): ProductsNavigationApi
}