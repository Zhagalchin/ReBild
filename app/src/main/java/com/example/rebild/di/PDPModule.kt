package com.example.rebild.di



import com.example.feature_products_api.domain.GetProductByIdUseCase
import com.example.feature_products_impl.domain.ProductsInteractor
import dagger.Binds
import dagger.Module

@Module
interface PDPModule {

    @Binds
    @FeatureScope
    fun bindGetByIdUseCase(impl: ProductsInteractor): GetProductByIdUseCase

}