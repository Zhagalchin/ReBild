package com.example.rebild.presentation.viewObject

import com.example.rebild.domain.ProductInList
import javax.inject.Inject

class ProductInListVOMapper @Inject constructor() {
    fun map(productInList: ProductInList): ProductInListVO {
        return ProductInListVO(
            guid = productInList.guid,
            image = productInList.image,
            name = productInList.name,
            rating = productInList.rating,
            price = productInList.price,
            isFavorite = productInList.isFavorite,
            isInCart = productInList.isInCart,
            description = productInList.description,
            count = productInList.count,
            inCartCount = productInList.inCartCount

        )
    }
}