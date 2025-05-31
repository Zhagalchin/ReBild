package com.example.rebild.di.vmModuls



import com.example.core_database_api.DatabaseComponentApi
import com.example.core_database_api.ProductDao
import com.example.core_network_api.ApiService
import com.example.core_network_api.NetworkComponentApi
import com.example.feature_products_api.domain.GetProductByIdUseCase
import com.example.feature_products_api.domain.GetProductsUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


interface CartDeps {

fun getProductsByIdUseCase() : GetProductsUseCase
    fun productDao(): ProductDao
    fun provideLoggingInterceptor(): HttpLoggingInterceptor
    fun apiService(): ApiService
    fun okHttpClient(): OkHttpClient
    fun getNetwork(): NetworkComponentApi
    fun getDataBase(): DatabaseComponentApi
}