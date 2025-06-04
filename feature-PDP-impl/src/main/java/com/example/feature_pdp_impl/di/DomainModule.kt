package com.example.feature_pdp_impl.di



import com.example.feature_pdp_api.domain.GetProductByIdUseCase
import com.example.feature_pdp_impl.domain.ProductsInteractor
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {
    @Binds
    fun bindGetProductsUseCase(impl: ProductsInteractor): GetProductByIdUseCase

}