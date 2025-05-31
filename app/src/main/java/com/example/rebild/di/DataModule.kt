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

    companion object{
//        @Provides
//        @ApplicationScope
//        fun provideLoggingInterceptor(): HttpLoggingInterceptor {
//            return HttpLoggingInterceptor().apply {
//                level = HttpLoggingInterceptor.Level.BODY
//            }
//        }

//        @Provides
//        @ApplicationScope
//        fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
//            return OkHttpClient.Builder()
//                .addInterceptor(logging)
//                .connectTimeout(30, TimeUnit.SECONDS)
//                .readTimeout(30, TimeUnit.SECONDS)
//                .writeTimeout(30, TimeUnit.SECONDS)
//                .build()
//        }
//
//        @Provides
//        @ApplicationScope
//        fun provideApiService(client: OkHttpClient): ApiService {
//            return Retrofit.Builder()
//                .baseUrl("https://675d888763b05ed079781f3e.mockapi.io/api/")
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(ApiService::class.java)
//        }

//        @Provides
//        @ApplicationScope
//        fun provideDataBase(application: Application): AppDataBase {
//            return Room.databaseBuilder(
//                application,
//                AppDataBase::class.java,
//                "app-db"
//            ).build()
//        }
//
//        @Provides
//        @ApplicationScope
//        fun provideProductDao(dataBase: AppDataBase): ProductDao {
//            return dataBase.productDAO()
//        }
    }
}