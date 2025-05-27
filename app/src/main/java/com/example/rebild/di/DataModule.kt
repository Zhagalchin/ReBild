package com.example.rebild.di

import android.app.Application
import androidx.room.Room
import com.example.rebild.data.repositoriesImpl.ProductRepositoryImpl

import com.example.rebild.domain.repositories.ProductsRepository
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