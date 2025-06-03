package com.example.rebild.di

import com.example.core_common.ComponentInjector
import com.example.feature_products_impl.presentation.ProductsFragment
import com.example.rebild.presentation.view.CartFragment
import javax.inject.Inject

class FeatureComponentInjector @Inject constructor(
    private val appComponent: AppComponent
): ComponentInjector {
    override fun inject(target: Any) {
        when (target){
            is ProductsFragment -> TODO()
            is PDPComponent -> TODO()
            is CartFragment -> TODO()
            else -> throw IllegalArgumentException("Unknown fragment type: ${target::class.java}")
        }
    }

    private fun injectProductsFragment(fragment: ProductsFragment){
TODO("Тут нужно будет создать через фабрику дагера ")
    }
}