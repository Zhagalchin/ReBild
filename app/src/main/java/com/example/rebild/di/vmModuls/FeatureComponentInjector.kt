package com.example.rebild.di.vmModuls

import android.app.Application
import com.example.core_database_api.DatabaseComponentApi
import com.example.core_database_api.ProductDao
import com.example.core_database_impl.DatabaseComponentImpl
import com.example.core_network_api.ApiService
import com.example.core_network_impl.NetworkComponentImpl
import com.example.feature_products_api.di.ProductsFeatureDeps
import com.example.feature_products_impl.di.ProductsComponentImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

interface FeatureComponentInjector {

    fun createProductsComponent(application: Application): ProductsComponentImpl{
        return ProductsComponentImpl.initAndGet(object : ProductsFeatureDeps{
            override fun productDao(): ProductDao {
             return  DatabaseComponentImpl.getAndInit(application).productDao()
            }

            override fun provideLoggingInterceptor(): HttpLoggingInterceptor {
                return NetworkComponentImpl.initAndGet().provideLoggingInterceptor()

            }

            override fun apiService(): ApiService {
                return NetworkComponentImpl.initAndGet().apiService()

            }

            override fun okHttpClient(): OkHttpClient {
                return NetworkComponentImpl.initAndGet().okHttpClient()

            }
        })
    }
}