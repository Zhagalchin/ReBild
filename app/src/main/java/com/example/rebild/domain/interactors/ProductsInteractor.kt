package com.example.rebild.domain.interactors


import com.example.feature_products_api.domain.ProductInList
import com.example.feature_products_api.domain.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductsInteractor @Inject constructor(private val productsRepository: ProductsRepository): GetProductByIdUseCase,
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

    override suspend fun getProductById(guid: String): ProductInList? {
        return productsRepository.getProductById(guid)
    }

    override suspend fun refreshProducts()  {
        productsRepository.refreshProducts()

    }


    override suspend fun updateFavoriteStatus(guid: String, isFavorite: Boolean) {
        productsRepository.updateFavoriteStatus(guid, isFavorite)
    }


}