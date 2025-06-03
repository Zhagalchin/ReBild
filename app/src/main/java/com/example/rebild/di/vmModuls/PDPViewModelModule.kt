package com.example.rebild.di.vmModuls

import androidx.lifecycle.ViewModel
import com.example.core_common.ViewModelKey
import com.example.rebild.presentation.viewModel.PDPViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PDPViewModelModule {
    @IntoMap
    @ViewModelKey(PDPViewModel::class)
    @Binds
    fun bindPDPViewModel(impl: PDPViewModel): ViewModel

}