package com.example.feature_pdp_api.domain

import kotlinx.coroutines.flow.Flow


interface ProductsRepository {


    suspend fun getProductById(guid: String): ProductInList?



}