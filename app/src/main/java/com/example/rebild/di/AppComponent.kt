package com.example.rebild.di

import android.app.Application
import com.example.core_database_api.DatabaseComponentApi
import com.example.core_network_api.NetworkComponentApi
import com.example.feature_cart_api.domain.ProductsRepository
import com.example.feature_products_impl.di.ViewModelFactoryModule
import com.example.rebild.domain.interactors.GetProductsUseCase
import dagger.BindsInstance
import dagger.Component


@ApplicationScope
@Component(
    modules = [AppModule::class],
    dependencies = [NetworkComponentApi::class, DatabaseComponentApi::class]
)
interface AppComponent {

    fun application(): Application
//    fun componentInjector(): FeatureComponentInjector


    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance application: Application,
                   networkComponentApi: NetworkComponentApi,
                   databaseComponentApi: DatabaseComponentApi
                   ): AppComponent
    }
}