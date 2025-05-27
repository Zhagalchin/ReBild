package com.example.rebild.data.retrofit

import com.example.rebild.data.dto.ProductApiDTO
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProductListDTO(): List<ProductApiDTO>
}