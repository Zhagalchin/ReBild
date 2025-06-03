package com.example.rebild.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_products_api.presentation.ProductInListVO
import com.example.feature_products_api.presentation.ProductsUiState
import com.example.feature_products_impl.presentation.ProductInListVOMapper
import com.example.rebild.domain.interactors.GetProductByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class PDPViewModel @Inject constructor(
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val mapper: ProductInListVOMapper
) : ViewModel() {

    private val _productProductsUiState = MutableStateFlow<ProductsUiState<ProductInListVO>>(ProductsUiState.Idle)
    val productProductsUiState: StateFlow<ProductsUiState<ProductInListVO>> = _productProductsUiState

    fun getProductById(productId: String) {
        Log.e("Inject", "$this")

        viewModelScope.launch {
            _productProductsUiState.value = ProductsUiState.Loading
            try {
                getProductByIdUseCase.getProductById(productId)?.let { product->
                    _productProductsUiState.value = ProductsUiState.Success(mapper.map(product))
                }?: run {
                    _productProductsUiState.value = ProductsUiState.Error("Product not found")
                }

            } catch (e: Exception){
                _productProductsUiState.value = ProductsUiState
                    .Error("Ошибка загрузки деталей ${e.message}")
                Log.d("API", "Error loading products: ${e.message}")
            }
        }
    }






}
