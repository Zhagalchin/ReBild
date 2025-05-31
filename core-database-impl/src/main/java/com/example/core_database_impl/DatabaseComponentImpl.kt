package com.example.core_database_impl

import android.app.Application
import com.example.core_database_api.DatabaseComponentApi
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DatabaseModule::class])
interface DatabaseComponentImpl: DatabaseComponentApi {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance application: Application): DatabaseComponentImpl
    }
    companion object{

        @Volatile
        private var instance: DatabaseComponentImpl? = null
        fun getAndInit(application: Application): DatabaseComponentImpl{
            return instance ?: synchronized(this){
                instance ?:  DaggerDatabaseComponentImpl.factory().create(application)
                    .also{ instance = it}
            }
        }

    }
}