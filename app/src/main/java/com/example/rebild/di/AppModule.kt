package com.example.rebild.di

import android.app.Application
import com.example.core_common.ComponentInjector
import dagger.Module
import dagger.Provides

@Module
interface AppModule {
    companion object{

        @Provides
        @ApplicationScope
        fun provideComponentInjector(): ComponentInjector {
            return FeatureComponentInjector()
        }

    }
}