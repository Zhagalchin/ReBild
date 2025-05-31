package com.example.rebild.di

import com.example.core_common.ComponentInjector
import dagger.Module
import dagger.Provides

@Module
interface AppModule {
    companion object{

        @Provides
        @ApplicationScope
        fun provideComponentInjector(appComponent: AppComponent): ComponentInjector {
            return FeatureComponentInjector(appComponent)
        }
    }
}