package com.example.feature_products_api.di

import com.example.core_database_api.ProductDao
import com.example.core_network_api.ApiService
import com.example.feature_cart_api.domain.ProductsNavigationApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

interface ProductsFeatureDeps {
    fun productDao(): ProductDao
    fun provideLoggingInterceptor(): HttpLoggingInterceptor
    fun apiService(): ApiService
    fun okHttpClient(): OkHttpClient
    fun productsNavigationApi(): com.example.feature_cart_api.domain.ProductsNavigationApi
}