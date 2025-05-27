package com.example.rebild.domain

data class ProductInList (
    val guid: String,
    val image: String,
    val name: String,
    val price: String,
    val rating: Double,
    val isFavorite: Boolean,
    val isInCart: Boolean,
    val description: String = "",
    val count: Int ,
    val inCartCount: Int = 0,
    )