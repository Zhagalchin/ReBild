package com.example.rebild.domain.interactors

import com.example.rebild.domain.ProductInList

interface GetProductByIdUseCase {

   suspend fun getProductById(guid: String): ProductInList?


}