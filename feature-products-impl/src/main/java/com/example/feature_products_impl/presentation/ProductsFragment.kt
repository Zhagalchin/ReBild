package com.example.feature_products_impl.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.core_common.ViewModelFactory
import com.example.feature_products_impl.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter


    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val vm: ProductsViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ProductsViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

//        val appComponent = (requireActivity().application as MyApp).component
//
//        DaggerProductsComponent.factory()
//            .create(this, appComponent)
//            .inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("ProductsFragment", "onViewCreated: ${this.hashCode()}")
        return inflater.inflate(R.layout.pdp_fragment_layout, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)


        val rootView = view.findViewById<View>(R.id.rootLayout)

        ViewCompat.setOnApplyWindowInsetsListener(rootView) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            view.setPadding(
                view.paddingLeft,
                systemBars.top,
                view.paddingRight,
                view.paddingBottom
            )
            insets
        }

        val toCartButton = view.findViewById<Button>(R.id.toCartBtn)
        toCartButton.setOnClickListener {
            openCartFragment()
        }


        val swipeRefreshLayout = view
            .findViewById<SwipeRefreshLayout>(R.id.swipeRefresh)
        if (savedInstanceState == null){
            Log.e("ProductsFragment", "First time loading data")
            vm.refreshData()
        }
        swipeRefreshLayout.setOnRefreshListener {
            vm.loadProducts()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                vm.uiState.collect { state ->
                    when (state) {
                        is ProductsUiState.Error -> {
                            "Проблемы с интернетом".showError()
                            swipeRefreshLayout.isRefreshing = false
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


        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Создаем адаптер
        adapter = ProductAdapter(
            onItemClick = { productId -> openPDPFragment(productId) },
            onFavoriteClick = { guid, isFavorite ->
                vm.updateFavoriteStatus(guid, isFavorite)
            },
            onCartCountChanged = {guid, newCount ->
                vm.updateCartCount(guid, newCount)
            })



        recyclerView.adapter = adapter

    }


    private fun String.showError() {
        Snackbar.make(requireView(), this, Snackbar.LENGTH_LONG)
            .setAction("Повторить") { vm.loadProducts() }
            .show()
    }


    private fun openPDPFragment(productId: String) {
        val bundle = Bundle().apply {
            putString("productId", productId)
        }

//        requireActivity().supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainer, PDPFragment::class.java, bundle)
//            .addToBackStack(null)
//            .commit()
    }


    private fun openCartFragment() {

//        requireActivity().supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.fragmentContainer, CartFragment())
//            .addToBackStack(null)
//            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("fragment", "onDestroyView")

    }



}
