package com.example.feature_products_api.di

import androidx.fragment.app.Fragment

interface ProductsNavigationApi {
    fun isClosed(fragment: Fragment): Boolean
//    fun openPDP( guid: String)
//    fun openCart()
}