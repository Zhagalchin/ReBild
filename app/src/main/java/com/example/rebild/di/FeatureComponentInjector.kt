package com.example.rebild.di

import android.app.Application
import com.example.core_database_api.DatabaseComponentApi
import com.example.core_database_api.ProductDao
import com.example.core_database_impl.DatabaseComponentImpl
import com.example.core_network_api.ApiService
import com.example.core_network_api.NetworkComponentApi
import com.example.core_network_impl.NetworkComponentImpl
import com.example.feature_products_api.di.ProductsFeatureDeps
import com.example.feature_products_impl.di.ProductsComponentImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject

interface FeatureComponentInjector  {
    fun createProductsComponent(application: Application): ProductsComponentImpl{
        return ProductsComponentImpl.initAndGet(object : ProductsFeatureDeps {
            override fun getNetwork(): NetworkComponentApi {
                return  NetworkComponentImpl.initAndGet()
            }

            override fun productDao(): ProductDao {
              return  getDataBase().productDao()
            }

            override fun apiService(): ApiService {
                return getNetwork().apiService()
            }

            override fun okHttpClient(): OkHttpClient {
                return getNetwork().okHttpClient()
            }

            override fun provideLoggingInterceptor(): HttpLoggingInterceptor {
                return getNetwork().provideLoggingInterceptor()
            }

            override fun getDataBase(): DatabaseComponentApi {
                return DatabaseComponentImpl.initAndGet(application)
            }
        })
    }
}