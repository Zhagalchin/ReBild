package com.example.feature_products_impl.di

import com.example.feature_cart_api.domain.ProductsRepository
import com.example.feature_products_impl.repo.ProductRepositoryImpl

import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun bindRepository(impl: ProductRepositoryImpl): com.example.feature_cart_api.domain.ProductsRepository

}