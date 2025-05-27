package com.example.rebild.di

import android.app.Application
import com.example.core_database_api.DatabaseComponentApi
import com.example.core_database_impl.DatabaseComponentImpl
import com.example.core_network_api.NetworkComponentApi
import com.example.core_network_impl.NetworkComponentImpl
import com.example.feature_products_api.di.ProductsFeatureDeps
import com.example.feature_products_impl.di.ProductsComponentImpl
import javax.inject.Inject

class FeatureComponentInjector @Inject constructor(private val appComponent: AppComponent) {
    fun createProductsComponent(application: Application): ProductsComponentImpl{
        return ProductsComponentImpl.initAndGet(object : ProductsFeatureDeps {
            override fun getNetwork(): NetworkComponentApi {
                return  NetworkComponentImpl.initAndGet()
            }

            override fun getDataBase(): DatabaseComponentApi {
                return DatabaseComponentImpl.initAndGet(application)
            }
        })
    }
}