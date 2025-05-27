package com.example.feature_products_api.domain

import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProducts(): Flow<List<ProductInList>>
    suspend fun getProductsInCart(): Flow<List<ProductInList>>

    suspend fun getProductById(guid: String): ProductInList?

    suspend fun updateFavoriteStatus(guid: String, isFavorite: Boolean)
    suspend fun refreshProducts()
    suspend fun updateCartCount(guid: String, count: Int)


}