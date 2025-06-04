package com.example.feature_cart_impl.di

import androidx.lifecycle.ViewModelProvider
import com.example.feature_cart_impl.presentation.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}