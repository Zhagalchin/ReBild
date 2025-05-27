package com.example.core_network_api

import kotlinx.serialization.Serializable

@Serializable
data class ProductApiDTO (
    val guid: String,
    val image: String,
    val name: String,
    val price: String,
    val rating: Double,
    val isFavorite: Boolean,
    val isInCart: Boolean,
    val count: Int = 0, )