package com.example.feature_pdp_impl.di


import com.example.feature_pdp_api.di.PDPFeatureDeps
import com.example.feature_pdp_impl.presentation.PDPFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [PDPFeatureDeps::class],
    modules = [PDPViewModelModule::class, DataModule::class, DomainModule::class]
)
interface PDPComponent {
    fun inject(fragment: PDPFragment)

    fun getInstance(): PDPComponent{
        return checkNotNull(instance)
    }

    @Component.Factory
    interface Factory {
        fun create(
            deps: PDPFeatureDeps
        ): PDPComponent
    }

    companion object {

        fun getInstance(): PDPComponent{
            return checkNotNull(instance)
        }
        @Volatile
        private var instance: PDPComponent? = null

        fun initAndGet(deps: PDPFeatureDeps): PDPComponent {
            return instance ?: synchronized(this) {
               instance ?: DaggerPDPComponent.factory().create(deps).also {
                   instance = it
               } }
        }
    }

}