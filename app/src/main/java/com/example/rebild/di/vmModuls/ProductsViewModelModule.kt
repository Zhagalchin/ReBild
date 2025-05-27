package com.example.rebild.di.vmModuls

import androidx.lifecycle.ViewModel
import com.example.rebild.di.ViewModelKey
import com.example.rebild.presentation.viewModel.ProductsViewModel

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