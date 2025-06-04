package com.example.feature_pdp_api.domain



interface GetProductByIdUseCase {
   suspend fun getProductById(guid: String): ProductInList?
}