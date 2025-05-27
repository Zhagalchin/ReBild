package com.example.rebild.data.repositoriesImpl

import android.util.Log
import com.example.core_database_api.ProductDao
import com.example.core_database_api.ProductEntity

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class LocalProductSource @Inject constructor(
    private val dao: ProductDao
) {

    fun getProducts(): Flow<List<ProductEntity>> {
        return dao.getAll()
    }
    suspend fun getProductById(guid: String): ProductEntity? {
Log.e("Inject", "$this")
        return dao.getById(guid)
    }

    suspend fun updateCount(productEntity: ProductEntity?){
        productEntity?.let {oldCountProduct->
            val updateProduct = oldCountProduct.copy(count = oldCountProduct.count + 1)
            dao.updateProduct(updateProduct)
        }
    }

    suspend fun updateFavoriteStatus(guid: String, isFavorite: Boolean) {
        val product = getProductById(guid)
        product?.let { oldProduct ->
            val updateProduct = oldProduct.copy(isFavorite = isFavorite)
            dao.updateProduct(updateProduct)
        }

    }
    suspend fun updateCartCount(guid: String, count: Int) {
        val product = getProductById(guid)
        product?.let {
            val isInCart = count > 0
            val updateProduct = it.copy(inCartCount = count, isInCart = isInCart)
            dao.updateProduct(updateProduct)

        }
    }


    suspend fun getExistingEntities() = dao.getAll().first()

    suspend fun refreshProducts(
        convertedToEntity: List<ProductEntity>,
        existingEntities: List<ProductEntity>
    )  {
        try {
            val mergedEntities = convertedToEntity.map { newEntities ->
                val old = existingEntities.find { it.guid == newEntities.guid }
                if (old != null) {
                    newEntities.copy(
                        count = old.count,
                        isFavorite = old.isFavorite,
                        inCartCount = old.inCartCount,
                        isInCart = old.isInCart
                    )
                } else {
                    newEntities
                }
            }
            dao.clear()
            dao.insertAll(mergedEntities)
            Log.e("refreshProducts", "Thread is ${Thread.currentThread().name}")
        } catch (e: Exception) {
            Log.e("Repository", "Refresh error")
            throw e
        }
    }

}