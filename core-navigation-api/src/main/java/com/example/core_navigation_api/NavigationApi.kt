package com.example.core_navigation_api

interface NavigationApi {
    fun openProductDetails(guid: String)
    fun openCart()
    fun navigateBack()
}