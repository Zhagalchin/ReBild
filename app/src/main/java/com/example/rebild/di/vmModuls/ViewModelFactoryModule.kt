package com.example.rebild.di.vmModuls

import androidx.lifecycle.ViewModelProvider
import com.example.rebild.presentation.viewModel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}