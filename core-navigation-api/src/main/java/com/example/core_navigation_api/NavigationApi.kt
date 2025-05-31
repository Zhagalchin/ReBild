package com.example.core_navigation_api

import com.example.feature_products_api.di.ProductsNavigationApi

interface NavigationApi {
    fun getProductsNavigator(): ProductsNavigationApi
}