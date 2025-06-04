package com.example.feature_cart_impl.di


import com.example.feature_cart_api.domain.GetProductsUseCase
import com.example.feature_cart_impl.domain.ProductsInteractor
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {
    @Binds
    fun bindGetProductsUseCase(impl: ProductsInteractor): GetProductsUseCase

}