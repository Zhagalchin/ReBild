package com.example.feature_products_impl.domain

import com.example.core_database_api.ProductEntity
import com.example.core_network_api.ProductApiDTO
import com.example.feature_products_api.domain.ProductInList

import javax.inject.Inject


class DomainMapper @Inject constructor(){
    fun mapToEntity(dto: ProductApiDTO): ProductEntity = ProductEntity(
        guid = dto.guid,
        name = dto.name,
        price = dto.price,
        image = dto.image,
        rating = dto.rating,
        isFavorite = dto.isFavorite,
        isInCart = dto.isInCart,
        count = dto.count,
    )
    fun mapFromEntity(entity: ProductEntity): ProductInList = ProductInList(
        guid = entity.guid,
        name = entity.name,
        price = entity.price,
        image = entity.image,
        rating = entity.rating,
        isFavorite = entity.isFavorite,
        isInCart = entity.isInCart,
        count = entity.count,
        inCartCount = entity.inCartCount
    )

}