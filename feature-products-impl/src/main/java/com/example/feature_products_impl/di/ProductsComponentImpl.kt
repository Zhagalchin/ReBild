package com.example.feature_products_impl.di

import com.example.feature_products_api.di.ProductsFeatureDeps
import com.example.feature_products_impl.presentation.ProductsFragment
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
       private var _daggerProductComponent: ProductsComponentImpl? = null


        fun getInstance(): ProductsComponentImpl{
            return checkNotNull(_daggerProductComponent)
        }

        fun initAndGet(deps: ProductsFeatureDeps): ProductsComponentImpl {
            return _daggerProductComponent ?: synchronized(this) {
                _daggerProductComponent ?: DaggerProductsComponentImpl.factory().create(deps).also {
                    _daggerProductComponent = it
                }
            }
        }
    }

    fun inject(fragment: ProductsFragment)
}