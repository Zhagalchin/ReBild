package com.example.rebild.di



import com.example.feature_products_api.domain.GetProductsUseCase
import com.example.feature_products_impl.domain.ProductsInteractor
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {
    @Binds
    @ApplicationScope
    fun bindGetProductsUseCase(impl: ProductsInteractor): GetProductsUseCase

}