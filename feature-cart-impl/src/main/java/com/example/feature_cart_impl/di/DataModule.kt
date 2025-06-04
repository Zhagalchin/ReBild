package com.example.feature_cart_impl.di

import com.example.feature_cart_api.domain.ProductsRepository
import com.example.feature_cart_impl.repositories.ProductRepositoryImpl

import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun bindRepository(impl: ProductRepositoryImpl): ProductsRepository

}