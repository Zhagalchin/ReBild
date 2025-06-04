package com.example.feature_pdp_impl.domain

import com.example.feature_pdp_api.domain.GetProductByIdUseCase
import com.example.feature_pdp_api.domain.ProductInList
import com.example.feature_pdp_api.domain.ProductsRepository

import javax.inject.Inject

class ProductsInteractor @Inject constructor(private val productsRepository: ProductsRepository):
    GetProductByIdUseCase {

    override suspend fun getProductById(guid: String): ProductInList? {
        return productsRepository.getProductById(guid)
    }







}