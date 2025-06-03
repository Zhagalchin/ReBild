package com.example.rebild.presentation.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.example.feature_products_api.presentation.ProductInListVO
import com.example.feature_products_api.presentation.ProductsUiState
import com.example.feature_products_impl.presentation.ProductsViewModel
import com.example.rebild.R
import com.example.rebild.di.DaggerPDPComponent
import com.example.rebild.di.MyApp
import com.example.rebild.di.PDPComponent
import com.example.rebild.presentation.viewModel.PDPViewModel

import com.example.rebild.presentation.viewModel.ViewModelFactory

import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import javax.inject.Inject

class PDPFragment : Fragment(R.layout.pdp_fragment) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: PDPViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[PDPViewModel::class.java]
    }
    private val vm: ProductsViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ProductsViewModel::class.java]
    }
    private lateinit var pdpComponent: PDPComponent


    private lateinit var progressBar: ProgressBar
    private lateinit var productNameTextView: TextView
    private lateinit var productPriceTextView: TextView
    private lateinit var productImageView: ImageView
    private lateinit var productRatingBar: RatingBar


    override fun onAttach(context: Context) {
val appComponent = (requireActivity().application as MyApp).appComponent
        DaggerPDPComponent.factory()
            .create(this,appComponent)
            .inject(this)

        super.onAttach(context)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productId = arguments?.getString("productId")
        if (productId != null) {
            viewModel.getProductById(productId)
        }

        setUpView(view)


        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.productProductsUiState.collect { state ->
                    when (state) {
                        is ProductsUiState.Error -> {
                            Snackbar.make(requireView(), state.message, Snackbar.LENGTH_LONG)
                                .setAction("Повторить") { vm.loadProducts() }
                                .show()
                        }

                        is ProductsUiState.Idle -> TODO()
                        is ProductsUiState.Loading -> {
                            progressBar.visibility = View.VISIBLE
                        }

                        is ProductsUiState.Success -> {
                            progressBar.visibility = View.GONE
                            setUpPDP(state.products, view)
                        }
                    }
                }

            }
        }
    }

    private fun setUpView(view: View) {
        productNameTextView = view.findViewById(R.id.nameTV)
        productPriceTextView = view.findViewById(R.id.priceTV)
        productImageView = view.findViewById(R.id.productIV)
        progressBar = view.findViewById(R.id.progressBarPDP)
        productRatingBar = view.findViewById(R.id.ratingView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        setFragmentResult()
    }

    private fun setFragmentResult() {
        requireActivity().supportFragmentManager.setFragmentResult("pdp_closed",
            bundleOf())
    }

    private fun setUpPDP(productInListVO: ProductInListVO?, view: View) {
        productInListVO?.let {
            productNameTextView.text = it.name
            productRatingBar.rating = it.rating.toFloat()
            productPriceTextView.text = resources.getString(R.string.prise_format, it.price)
            Glide.with(view)
                .load(it.image)
                .into(productImageView)
        }
    }

}