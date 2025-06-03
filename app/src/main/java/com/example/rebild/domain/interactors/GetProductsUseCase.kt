package com.example.rebild.domain.interactors


import com.example.feature_products_api.domain.ProductInList
import kotlinx.coroutines.flow.Flow

interface GetProductsUseCase {
   suspend fun getProducts(): Flow<List<ProductInList>>
   suspend fun getProductsInCart(): Flow<List<ProductInList>>
   suspend fun updateFavoriteStatus(guid: String, isFavorite: Boolean)
   suspend fun refreshProducts()
   suspend fun updateCartCount(guid: String, newCount: Int)
}