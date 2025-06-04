package com.example.feature_cart_impl.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.feature_cart_api.presentation.ProductsUiState
import com.example.feature_cart_impl.R
import com.example.feature_cart_impl.di.CartComponent


import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import javax.inject.Inject

class CartFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val vm: CartViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CartViewModel::class.java]
    }
    private lateinit var adapter: ProductAdapter


    override fun onAttach(context: Context) {
        super.onAttach(context)
        CartComponent.getInstance().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cart_layout, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val swipeRefreshLayout = view
            .findViewById<SwipeRefreshLayout>(R.id.swipeRefresh)
        swipeRefreshLayout.setOnRefreshListener {
            vm.loadProducts()
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        adapter = ProductAdapter(
            onItemClick = {},
            onFavoriteClick = { guid, isFavorite -> vm.updateFavoriteStatus(guid,
                isFavorite) },
            onCartCountChanged = { guid, inCartCount ->
                vm.updateCartCount(guid, inCartCount)
            }
        )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                vm.uiState.collect { state ->
                    when (state) {
                        is ProductsUiState.Error -> {
                            "Проблемы с интернетом".showError()
                        }

                        is ProductsUiState.Loading -> swipeRefreshLayout.isRefreshing = true
                        is ProductsUiState.Success -> {
                            swipeRefreshLayout.isRefreshing = false
                            adapter.submitList(state.products)
                        }
                        else -> Unit
                    }
                }

            }
        }
    }

    private fun String.showError() {
        Snackbar.make(requireView(), this, Snackbar.LENGTH_LONG)
            .setAction("Повторить") { vm.loadProducts() }
            .show()
    }

}