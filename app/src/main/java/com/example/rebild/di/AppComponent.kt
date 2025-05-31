package com.example.rebild.di

import android.app.Application
import com.example.core_database_api.DatabaseComponentApi
import com.example.core_network_api.NetworkComponentApi
import com.example.feature_products_api.di.ProductsFeatureDeps
import com.example.feature_products_api.domain.GetProductsUseCase
import com.example.feature_products_api.domain.ProductsRepository

import dagger.BindsInstance
import dagger.Component
import okhttp3.OkHttpClient


@ApplicationScope
@Component(
    modules = [DomainModule::class, DataModule::class],
    dependencies = [NetworkComponentApi::class, DatabaseComponentApi::class]
)
interface AppComponent {

    fun application(): Application

    //    fun apiService(): ApiService
//    fun okHttpClient(): OkHttpClient
//    fun productDao(): ProductDao
//    fun productsRepository(): ProductsRepository
//    fun productsUseCase(): GetProductsUseCase


    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            @BindsInstance application: Application,
            networkComponentApi: NetworkComponentApi,
            databaseComponentApi: DatabaseComponentApi
        ): AppComponent
    }
}