package com.example.rebild.di

import android.app.Application
import com.example.core_common.ComponentInjector
import com.example.feature_products_api.domain.ProductsRepository
import com.example.feature_products_impl.repo.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface AppModule {


    @Binds
    fun bindComponentInjector(impl: FeatureComponentInjector): ComponentInjector

//    companion object{
//
//        @Provides
//        @ApplicationScope
//        fun provideComponentInjector(): ComponentInjector {
//            return FeatureComponentInjector
//        }
//
//    }
}