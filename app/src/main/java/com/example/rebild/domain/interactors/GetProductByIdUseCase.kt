package com.example.rebild.domain.interactors

import com.example.feature_products_api.domain.ProductInList


interface GetProductByIdUseCase {

   suspend fun getProductById(guid: String): ProductInList?


}