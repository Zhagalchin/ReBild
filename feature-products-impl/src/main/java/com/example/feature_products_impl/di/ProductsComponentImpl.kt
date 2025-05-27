package com.example.feature_products_impl.di


import com.example.feature_products_api.di.ProductsFeatureDeps
import com.example.feature_products_impl.presentation.ProductsFragment

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ProductsModule::class, ProductsViewModelModule::class,
        DataModule::class, DomainModule::class, ViewModelFactoryModule::class],
    dependencies = [ProductsFeatureDeps::class]
)
interface ProductsComponentImpl {
    fun inject(fragment: ProductsFragment)

    @Component.Factory
    interface Factory{
        fun create(deps: ProductsFeatureDeps): ProductsComponentImpl
    }
    companion object{

        @Volatile
        private var daggerProductComponent: DaggerProductsComponentImpl? = null

        fun initAndGet(deps: ProductsFeatureDeps): ProductsComponentImpl {
            return daggerProductComponent ?: synchronized(this) {
                daggerProductComponent ?: DaggerProductsComponentImpl.factory().create(deps).also {
                    daggerProductComponent = it
                }
            }
        }
    }
}