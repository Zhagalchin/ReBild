package com.example.rebild.di.vmModuls

import androidx.lifecycle.ViewModel
import com.example.rebild.di.ViewModelKey
import com.example.rebild.presentation.viewModel.CartViewModel
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