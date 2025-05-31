package com.example.core_navigation_impl

import android.content.Context
import com.example.feature_products_api.di.ProductsFeatureDeps
import com.example.feature_products_impl.di.ProductsComponentImpl

//object FeatureInjectorProxy {
//
//    var isFirstAppLaunch = true
//
//    fun initFeatureProductsDI(appContext: Context){
//        ProductsComponentImpl.initAndGet(object :ProductsFeatureDeps{
//            override fun productDao(): com.example.core_database_api.ProductDao {
//                TODO("Not yet implemented")
//            }
//
//            override fun provideLoggingInterceptor(): okhttp3.logging.HttpLoggingInterceptor {
//                TODO("Not yet implemented")
//            }
//
//            override fun apiService(): com.example.core_network_api.ApiService {
//                TODO("Not yet implemented")
//            }
//
//            override fun okHttpClient(): okhttp3.OkHttpClient {
//                TODO("Not yet implemented")
//            }
//
//            override fun getNetwork(): com.example.core_network_api.NetworkComponentApi {
//                TODO("Not yet implemented")
//            }
//
//            override fun getDataBase(): com.example.core_database_api.DatabaseComponentApi {
//                TODO("Not yet implemented")
//            }
//        })
//    }
//}