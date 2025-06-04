package com.example.rebild.di

import android.app.Application
import com.example.core_database_api.ProductDao
import com.example.core_database_impl.DatabaseComponentImpl
import com.example.core_network_api.ApiService
import com.example.core_network_impl.NetworkComponentImpl
import com.example.feature_pdp_api.di.PDPFeatureDeps
import com.example.feature_pdp_impl.di.PDPComponent
import com.example.feature_products_api.di.ProductsFeatureDeps
import com.example.feature_products_api.domain.ProductsNavigationApi
import com.example.feature_products_impl.di.ProductsComponentImpl
import com.example.rebild.navigation.ProductsNavigationImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject

object FeatureComponentInjector {
    var isFirstAppLaunch = true


    fun createProductsComponent(application: Application){

       val productsComponent =  ProductsComponentImpl.initAndGet(object : ProductsFeatureDeps {

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

           override fun productsNavigationApi(): ProductsNavigationApi {
               return ProductsNavigationImpl()
           }
       })
    }

    fun createPDPComponent(application: Application){
        val PDPComponent = PDPComponent.initAndGet(object : PDPFeatureDeps {
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