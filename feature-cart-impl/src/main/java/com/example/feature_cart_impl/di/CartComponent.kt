package com.example.feature_cart_impl.di



import com.example.feature_cart_api.CartFeatureDeps
import com.example.feature_cart_impl.presentation.CartFragment
import dagger.BindsInstance
import dagger.Component


@Component(dependencies = [CartFeatureDeps::class],
    modules = [CartViewModelModule::class, ViewModelFactoryModule::class, DataModule::class, DomainModule::class])
interface CartComponent {
    fun inject(fragment: CartFragment)

    @Component.Factory
    interface Factory{
        fun create(
            deps: CartFeatureDeps
        ): CartComponent
    }

    companion object{

        fun getInstance(): CartComponent{
            return checkNotNull(instance)
        }

        @Volatile
        private var instance: CartComponent? = null

        fun initAndGet(deps: CartFeatureDeps): CartComponent{
            return instance ?: synchronized(this){
                instance ?: DaggerCartComponent.factory().create(deps).also {
                    instance = it
                }
            }
        }


    }
}