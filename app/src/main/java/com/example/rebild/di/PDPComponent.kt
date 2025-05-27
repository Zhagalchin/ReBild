package com.example.rebild.di


import com.example.rebild.di.vmModuls.PDPViewModelModule
import com.example.rebild.presentation.view.PDPFragment

import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(dependencies = [AppComponent::class],
    modules = [PDPModule::class, PDPViewModelModule::class])
interface PDPComponent {
    fun inject(fragment: PDPFragment)

    @Component.Factory
    interface Factory{
        fun create(
            @BindsInstance fragment: PDPFragment,
            appComponent: AppComponent
        ): PDPComponent
    }
}