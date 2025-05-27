package com.example.feature_products_impl.di

import com.example.feature_products_api.domain.GetProductsUseCase
import com.example.feature_products_api.domain.ProductsInteractor
import dagger.Binds
import dagger.Module
import javax.inject.Singleton
@Module
interface DomainModule {
    @Binds
    @Singleton
    fun bindGetProductsUseCase(impl: ProductsInteractor): GetProductsUseCase
}