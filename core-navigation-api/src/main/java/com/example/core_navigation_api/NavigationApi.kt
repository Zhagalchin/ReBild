package com.example.core_navigation_api

import com.example.feature_products_api.di.ProductsNavigatorApi


interface NavigationApi {
    fun getProductsNavigation(): ProductsNavigatorApi
    fun getPDPNavigation() //TODO
    fun getCartNavigation() //TODO
}