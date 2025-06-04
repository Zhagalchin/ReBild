package com.example.feature_products_impl.repo

import android.util.Log
import com.example.feature_products_impl.domain.DomainMapper
import com.example.feature_products_api.domain.ProductInList
import com.example.feature_products_api.domain.ProductsRepository



import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val localProductSource: LocalProductSource,
    private val remoteProductSource: RemoteProductSource,
    private val mapper: DomainMapper
): ProductsRepository {
    override suspend fun getProducts(): Flow<List<ProductInList>> {
        Log.e("Inject", "$this")
        return localProductSource.getProducts().map { list ->
            list.map { mapper.mapFromEntity(it) }
        }
    }

    override suspend fun getProductsInCart(): Flow<List<ProductInList>> {
        return getProducts().map { list -> list.filter {product-> product.isInCart } }
    }





    override suspend fun updateFavoriteStatus(guid: String, isFavorite: Boolean) {
        localProductSource.updateFavoriteStatus(guid, isFavorite)
    }
    override suspend fun updateCartCount(guid: String, count: Int) {
        localProductSource.updateCartCount(guid, count)
    }

    override suspend fun refreshProducts() {
        val dtos = remoteProductSource.getProducts()
        val convertedToEntity = dtos.map { mapper.mapToEntity(it) }
        val existingEntities = localProductSource.getExistingEntities()
        localProductSource.refreshProducts(convertedToEntity, existingEntities)
    }
}