package com.example.feature_pdp_impl.repo


import com.example.core_network_api.ApiService
import com.example.core_network_api.ProductApiDTO
import javax.inject.Inject

class RemoteProductSource @Inject constructor(
    private val api: ApiService
) {

    suspend fun getProducts():List<ProductApiDTO>{
        return api.getProductListDTO()
    }
}