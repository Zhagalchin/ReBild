package com.example.feature_products_api.di

import androidx.fragment.app.Fragment

interface ProductsNavigationApi {

    fun navigatePDO(fragment: Fragment, guid: String)

    fun navigateToCart(fragment: Fragment)
}