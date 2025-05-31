package com.example.rebild.di

import com.example.feature_products_api.di.ProductsFeatureDeps
import com.example.rebild.di.vmModuls.ProductsViewModelModule
import com.example.rebild.di.vmModuls.ViewModelFactoryModule
import com.example.rebild.presentation.view.ProductsFragment
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(dependencies = [AppComponent::class],
    modules = [ProductsModule::class, ProductsViewModelModule::class, ViewModelFactoryModule::class])
interface ProductsComponent {
    fun inject(fragment: ProductsFragment)

    @Component.Factory
    interface Factory{
        fun create(
            @BindsInstance fragment: ProductsFragment,
            productsFeatureDeps: ProductsFeatureDeps
        ): ProductsComponent
    }
}