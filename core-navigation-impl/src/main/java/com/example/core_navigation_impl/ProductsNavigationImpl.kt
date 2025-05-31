package com.example.core_navigation_impl

import androidx.fragment.app.Fragment
import com.example.feature_products_api.di.ProductsNavigatorApi
import com.example.feature_products_impl.presentation.ProductsFragment
import javax.inject.Inject

class ProductsNavigationImpl @Inject constructor(): ProductsNavigatorApi {
    override fun isClosed(fragment: Fragment): Boolean {
        return if (fragment.javaClass.simpleName != ProductsFragment::class.simpleName){
            fragment.activity?.supportFragmentManager?.findFragmentByTag(ProductsFragment::class.java.simpleName) == null
        } else true
    }

    override fun openProductDetails(fragment: Fragment, guid: String) {
        TODO("")
//        if (fragment.activity != null){
//            fragment.let {  }
//        }
    }

    override fun openCart(fragment: Fragment) {
        TODO("Not yet implemented")
    }
}