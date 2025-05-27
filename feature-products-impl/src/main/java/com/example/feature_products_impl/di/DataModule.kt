package com.example.feature_products_impl.di

import com.example.feature_products_api.domain.ProductsRepository
import com.example.feature_products_impl.data.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataModule {
    @Binds
    @Singleton
    fun bindRepository(impl: ProductRepositoryImpl): ProductsRepository

}