package com.example.rebild.di

import android.app.Application
import androidx.room.Room
import com.example.feature_products_api.domain.ProductsRepository
import com.example.feature_products_impl.data.ProductRepositoryImpl

import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindRepository(impl: ProductRepositoryImpl): ProductsRepository


}