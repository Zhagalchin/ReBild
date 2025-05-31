package com.example.rebild.di


import com.example.rebild.di.vmModuls.CartDeps
import com.example.rebild.di.vmModuls.CartViewModelModule
import com.example.rebild.di.vmModuls.ViewModelFactoryModule
import com.example.rebild.presentation.view.CartFragment

import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(dependencies = [CartDeps::class], modules = [CartViewModelModule::class])
interface CartComponent {
    fun inject(fragment: CartFragment)

    @Component.Factory
    interface Factory{
        fun create(
            @BindsInstance fragment: CartFragment,
            cartDeps: CartDeps
        ): CartComponent
    }
}