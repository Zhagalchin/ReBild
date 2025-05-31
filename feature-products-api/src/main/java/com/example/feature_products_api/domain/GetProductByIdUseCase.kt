package com.example.feature_products_api.domain


interface GetProductByIdUseCase {

   suspend fun getProductById(guid: String): ProductInList?


}