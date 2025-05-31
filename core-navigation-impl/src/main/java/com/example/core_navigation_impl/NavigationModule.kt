package com.example.core_navigation_impl

import com.example.feature_products_api.di.ProductsNavigationApi
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    fun bindProductsNavigator(impl: ProductsNavigatorImpl): ProductsNavigationApi

}