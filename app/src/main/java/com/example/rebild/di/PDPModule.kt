package com.example.rebild.di


import com.example.rebild.domain.interactors.GetProductByIdUseCase
import com.example.rebild.domain.interactors.ProductsInteractor
import dagger.Binds
import dagger.Module

@Module
interface PDPModule {

    @Binds
    @FeatureScope
    fun bindGetByIdUseCase(impl: ProductsInteractor): GetProductByIdUseCase

}