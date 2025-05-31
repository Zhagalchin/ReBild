package com.example.rebild.di

import android.app.Application
import com.example.core_database_api.DatabaseComponentApi
import com.example.core_database_api.ProductDao
import com.example.core_network_api.NetworkComponentApi
import com.example.rebild.domain.interactors.GetProductsUseCase
import com.example.rebild.domain.repositories.ProductsRepository
import dagger.BindsInstance
import dagger.Component


@ApplicationScope
@Component(
    modules = [DomainModule::class, DataModule::class, AppModule::class],
    dependencies = [NetworkComponentApi::class, DatabaseComponentApi::class]
)
interface AppComponent {

    fun application(): Application

    fun productsRepository(): ProductsRepository
    fun productsUseCase(): GetProductsUseCase
    fun componentInjector(): FeatureComponentInjector


    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance application: Application,
                   networkComponentApi: NetworkComponentApi,
                   databaseComponentApi: DatabaseComponentApi
                   ): AppComponent
    }
}