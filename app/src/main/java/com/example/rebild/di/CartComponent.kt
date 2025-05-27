package com.example.rebild.di


import com.example.rebild.di.vmModuls.CartViewModelModule
import com.example.rebild.di.vmModuls.ViewModelFactoryModule
import com.example.rebild.presentation.view.CartFragment

import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(dependencies = [AppComponent::class],
    modules = [ProductsModule::class, CartViewModelModule::class, ViewModelFactoryModule::class])
interface CartComponent {
    fun inject(fragment: CartFragment)

    @Component.Factory
    interface Factory{
        fun create(
            @BindsInstance fragment: CartFragment,
            appComponent: AppComponent
        ): CartComponent
    }
}