package com.example.core_network_api

import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProductListDTO(): List<ProductApiDTO>
}