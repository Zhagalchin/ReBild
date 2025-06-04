package com.example.feature_pdp_api.presentation


sealed class ProductsUiState<out T>{
    object Idle : ProductsUiState<Nothing>()
    object Loading : ProductsUiState<Nothing>()
    data class Success<T>(val products: T) : ProductsUiState<T>()
    data class Error(val message: String) : ProductsUiState<Nothing>()
}

