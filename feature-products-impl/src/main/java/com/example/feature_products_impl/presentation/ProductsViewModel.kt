package com.example.feature_products_impl.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_products_api.domain.GetProductsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.system.measureTimeMillis

class ProductsViewModel @Inject constructor(
    private val getProductUseCase: GetProductsUseCase,
    private val mapper: ProductInListVOMapper
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<ProductsUiState<List<ProductInListVO>>>(ProductsUiState.Idle)
    val uiState: StateFlow<ProductsUiState<List<ProductInListVO>>> = _uiState

    init {
        Log.e("Inject", "$this")

        val time = measureTimeMillis{
            viewModelScope.launch(Dispatchers.IO) {
                getProductUseCase.getProducts().collect { products ->
                    val mappedProducts = products.map { mapper.map(it) }
                    _uiState.value = ProductsUiState.Success(mappedProducts)
                }
            }
        }
        loadProducts()
        Log.e("TIME init", "time - ${time}")
    }

    fun loadProducts() {
        val time = measureTimeMillis {
            viewModelScope.launch {
                try {
                    _uiState.value = ProductsUiState.Loading
                    getProductUseCase.refreshProducts()
                    Log.e("loadProducts", "Thread is ${Thread.currentThread().name}")

                } catch (e: Exception) {
                    _uiState.value = ProductsUiState.Error(e.message ?: "Неизвестная ошибка")
                    Log.e("LoadingState.Error", e.message ?: "")
                }
            }

        }
        Log.e("TIME loadProducts", "time - ${time}")



    }

    fun updateCartCount(guid: String, cartCount: Int) {
        viewModelScope.launch {
            try {
                getProductUseCase.updateCartCount(guid, cartCount)
                val currentState = _uiState.value

                if (currentState is ProductsUiState.Success) {

                    Log.e("currentState", currentState.toString())

                    val updateList = currentState.products.map { productInListVO ->
                        Log.e("updateCartCount", productInListVO.inCartCount.toString())
                        if (productInListVO.guid == guid) {
                            productInListVO.copy(inCartCount = cartCount)

                        } else productInListVO
                    }
                    _uiState.value = ProductsUiState.Success(updateList)
                }
            } catch (e: Exception) {
                _uiState.value = ProductsUiState.Error("Ошибка обновления: ${e.message}")
                Log.e("API", "Update error: ${e.message}")
            }
        }
    }

    fun updateFavoriteStatus(guid: String, isFavorite: Boolean) {
        viewModelScope.launch {
            try {
                getProductUseCase.updateFavoriteStatus(guid, isFavorite)
                val currentState = _uiState.value
                if (currentState is ProductsUiState.Success) {
                    val updatedList = currentState.products.map { product ->
                        if (product.guid == guid) product.copy(isFavorite = isFavorite) else product
                    }
                    _uiState.value = ProductsUiState.Success(updatedList)
                }
            } catch (e: Exception) {
                _uiState.value = ProductsUiState.Error("Ошибка обновления: ${e.message}")
                Log.e("API", "Update error: ${e.message}")
            }
        }
    }

    fun refreshData() {
        val time = measureTimeMillis{
            viewModelScope.launch {
                Log.e("loadProducts", "refreshData")
                try {
                    getProductUseCase.getProducts().take(1).collect { products ->
                        val mappedProducts = products.map { mapper.map(it) }
                        _uiState.value = ProductsUiState.Success(mappedProducts)
                    }
                }catch (e: Exception){
                    Log.e("ProductsViewModel", "Error refreshing data: ${e.message}", e)
                }
            }
        }
        Log.e("TIME refreshData" , "time - ${time}")
    }
}