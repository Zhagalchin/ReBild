package com.example.feature_products_api.presentation


sealed class ProductsUiState<out T>{
    object Idle : ProductsUiState<Nothing>()
    object Loading : ProductsUiState<Nothing>()
    data class Success<T>(val products: T) : ProductsUiState<T>()
    data class Error(val message: String) : ProductsUiState<Nothing>()
}

