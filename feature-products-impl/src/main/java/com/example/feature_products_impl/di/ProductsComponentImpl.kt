package com.example.feature_products_impl.di

import com.example.feature_products_api.di.ProductsFeatureDeps
import com.example.feature_products_impl.presentation.ProductsFragment
import com.example.feature_products_impl.presentation.ProductsViewModel
import dagger.Component

@Component(dependencies = [ProductsFeatureDeps::class],
    modules = [DataModule::class, DomainModule::class, ViewModelFactoryModule::class, ProductsViewModelModule::class])
interface ProductsComponentImpl {

    @Component.Factory
    interface Factory{
        fun create(deps: ProductsFeatureDeps): ProductsComponentImpl
    }
    companion object{

        @Volatile
        var daggerProductComponent: ProductsComponentImpl? = null

        fun initAndGet(deps: ProductsFeatureDeps): ProductsComponentImpl {
            return daggerProductComponent ?: synchronized(this) {
                daggerProductComponent ?: DaggerProductsComponentImpl.factory().create(deps).also {
                    daggerProductComponent = it
                }
            }
        }
    }

    fun inject(fragment: ProductsFragment)
}