package com.example.core_network_api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


interface NetworkComponentApi {
    fun provideLoggingInterceptor(): HttpLoggingInterceptor
    fun apiService(): ApiService
    fun okHttpClient(): OkHttpClient
}