package com.example.core_database_impl

import android.app.Application
import androidx.room.Room
import com.example.core_database_api.AppDataBase
import com.example.core_database_api.ProductDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DatabaseModule {
    @Provides
    @Singleton
    fun provideDataBase(application: Application): AppDataBase {
        return Room.databaseBuilder(
            application,
            AppDataBase::class.java,
            "app-db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideProductDao(dataBase: AppDataBase): ProductDao {
        return dataBase.productDAO()
    }
}