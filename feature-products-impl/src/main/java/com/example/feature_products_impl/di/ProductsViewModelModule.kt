package com.example.feature_products_impl.di

import androidx.lifecycle.ViewModel
import com.example.core_common.ViewModelKey
import com.example.feature_products_impl.presentation.ProductsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ProductsViewModelModule {
    @IntoMap
    @ViewModelKey(ProductsViewModel::class)
    @Binds
    fun bindProductsViewModel(impl: ProductsViewModel): ViewModel

}