package com.example.feature_cart_impl.di

import androidx.lifecycle.ViewModel
import com.example.core_common.ViewModelKey
import com.example.feature_cart_impl.presentation.CartViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CartViewModelModule {
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    @Binds
    fun bindCartViewModel(impl: CartViewModel): ViewModel
}