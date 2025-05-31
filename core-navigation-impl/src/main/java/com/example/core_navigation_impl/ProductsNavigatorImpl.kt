package com.example.core_navigation_impl

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.feature_products_api.ProductsFragment
import com.example.feature_products_api.di.ProductsNavigationApi
import javax.inject.Inject

class ProductsNavigatorImpl @Inject constructor() : ProductsNavigationApi {

    private var fragmentManager: FragmentManager? = null
    private var containerId: Int = 0

    fun init(fragmentManager: FragmentManager, containerId: Int) {
        this.fragmentManager = fragmentManager
        this.containerId = containerId
    }

    override fun isClosed(fragment: Fragment): Boolean {
        return if (fragment.javaClass.simpleName != ProductsFragment::class.simpleName) {
            fragment.activity?.supportFragmentManager
                ?.findFragmentByTag(ProductsFragment::class.java.simpleName) == null
        } else true
    }
//
//    override fun openPDP(fragment: Fragment, guid: String) {
//        fragmentManager?.let { fm ->
//            val fragment = createPDPFragment(guid)
//            fm.beginTransaction()
//                .replace(containerId, fragment)
//                .addToBackStack(null)
//                .commit()
//        }
//    }
//
//    override fun openCart(fragment: Fragment) {
//        fragmentManager?.let { fm ->
//            val fragment = CartFragment()
//            fm.beginTransaction()
//                .replace(containerId, fragment)
//                .addToBackStack(null)
//                .commit()
//        }
//    }
//
//    private fun createPDPFragment(guid: String): Fragment {
//        return PDPFragment().apply {
//            arguments = Bundle().apply {
//                putString("productId", guid)
//            }
//        }
//    }
}