package com.example.feature_pdp_impl.presentation


import com.example.feature_pdp_api.domain.ProductInList
import com.example.feature_pdp_api.presentation.ProductInListVO
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