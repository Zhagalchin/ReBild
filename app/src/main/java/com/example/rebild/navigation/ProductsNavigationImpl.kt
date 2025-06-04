package com.example.rebild.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.feature_pdp_impl.presentation.PDPFragment
import com.example.feature_cart_api.domain.ProductsNavigationApi
import com.example.rebild.R
import javax.inject.Inject

class ProductsNavigationImpl @Inject constructor() :
    com.example.feature_cart_api.domain.ProductsNavigationApi {
    override fun navigatePDO(fragment: Fragment, guid: String) {
        if (fragment.activity != null) {
            fragment.activity?.let {
                //  FeatureComponentInjector. для PDP
                val newFragment = PDPFragment().apply {
                    arguments = Bundle().apply {
                        putString("productId", guid)
                    }
                }
                it.supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.fragmentContainer,
                        newFragment as Fragment,
                        PDPFragment::class.java.simpleName
                    )
                    .addToBackStack(fragment.javaClass.simpleName)
                    .commit()
            }
        }
    }

    override fun navigateToCart(fragment: Fragment) {
        TODO("Not yet implemented")
    }
}