package com.example.feature_products_impl.presentation


data class ProductInListVO(
    val guid: String,
    val image: String,
    val name: String,
    val price: String,
    val rating: Double,
    val isFavorite: Boolean,
    val isInCart: Boolean,
    val description: String = "",
    val count: Int,
    val inCartCount: Int = 0,
    )
