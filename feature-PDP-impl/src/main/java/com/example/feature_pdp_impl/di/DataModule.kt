package com.example.feature_pdp_impl.di

import com.example.feature_pdp_api.domain.ProductsRepository
import com.example.feature_pdp_impl.repo.ProductRepositoryImpl

import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun bindRepository(impl: ProductRepositoryImpl): ProductsRepository

}