package com.example.feature_pdp_impl.repo

import com.example.feature_pdp_api.domain.ProductInList
import com.example.feature_pdp_api.domain.ProductsRepository
import com.example.feature_pdp_impl.domain.DomainMapper


import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val localProductSource: LocalProductSource,
    private val remoteProductSource: RemoteProductSource,
    private val mapper: DomainMapper
): ProductsRepository {



    override suspend fun getProductById(guid: String): ProductInList? {
        val oldCountEntity = localProductSource.getProductById(guid)
        localProductSource.updateCount(oldCountEntity)
        return  oldCountEntity?.let { mapper.mapFromEntity(it) }

    }



}