package com.example.feature_cart_impl.domain


import com.example.feature_cart_api.domain.GetProductsUseCase
import com.example.feature_cart_api.domain.ProductInList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductsInteractor @Inject constructor(private val productsRepository: com.example.feature_cart_api.domain.ProductsRepository):
    GetProductsUseCase {
    override suspend fun getProducts(): Flow<List<ProductInList>> {
      return  productsRepository.getProducts()
    }

    override suspend fun getProductsInCart(): Flow<List<ProductInList>> {
       return productsRepository.getProductsInCart()
    }

    override suspend fun updateCartCount(guid: String, newCount: Int) = withContext(Dispatchers.IO) {
        productsRepository.updateCartCount(guid,newCount )
    }

    override suspend fun refreshProducts()  {
        productsRepository.refreshProducts()

    }


    override suspend fun updateFavoriteStatus(guid: String, isFavorite: Boolean) {
        productsRepository.updateFavoriteStatus(guid, isFavorite)
    }


}