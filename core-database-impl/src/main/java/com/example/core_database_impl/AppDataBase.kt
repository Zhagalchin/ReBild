package com.example.core_database_impl

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core_database_api.ProductDao
import com.example.core_database_api.ProductEntity

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun productDAO(): ProductDao
}