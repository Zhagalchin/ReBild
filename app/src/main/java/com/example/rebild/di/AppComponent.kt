package com.example.rebild.di

import android.app.Application
import com.example.rebild.data.retrofit.ApiService
import com.example.rebild.data.room.ProductDao
import com.example.rebild.domain.interactors.GetProductsUseCase
import com.example.rebild.domain.repositories.ProductsRepository
import dagger.BindsInstance
import dagger.Component
import okhttp3.OkHttpClient


@ApplicationScope
@Component(modules = [DomainModule::class, DataModule::class])
interface AppComponent {

    fun application(): Application
    fun apiService(): ApiService
    fun okHttpClient(): OkHttpClient
    fun productDao(): ProductDao
    fun productsRepository(): ProductsRepository
    fun productsUseCase(): GetProductsUseCase


    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}