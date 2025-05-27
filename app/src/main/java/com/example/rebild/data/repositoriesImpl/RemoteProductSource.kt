package com.example.rebild.data.repositoriesImpl

import com.example.rebild.data.dto.ProductApiDTO
import com.example.rebild.data.retrofit.ApiService
import javax.inject.Inject

class RemoteProductSource @Inject constructor(
    private val api: ApiService
) {

    suspend fun getProducts():List<ProductApiDTO>{
        return api.getProductListDTO()
    }
}