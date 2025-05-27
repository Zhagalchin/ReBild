package com.example.rebild.di


import com.example.rebild.domain.interactors.GetProductsUseCase
import com.example.rebild.domain.interactors.ProductsInteractor
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {
    @Binds
    @ApplicationScope
    fun bindGetProductsUseCase(impl: ProductsInteractor): GetProductsUseCase

}