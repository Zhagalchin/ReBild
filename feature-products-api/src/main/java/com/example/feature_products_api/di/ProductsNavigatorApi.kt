package com.example.feature_products_api.di

import androidx.fragment.app.Fragment


interface ProductsNavigatorApi {
    fun isClosed(fragment: Fragment): Boolean
    fun openProductDetails(fragment: Fragment, guid: String)
    fun openCart(fragment: Fragment)
}