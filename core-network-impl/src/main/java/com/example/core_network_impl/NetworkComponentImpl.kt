package com.example.core_network_impl

import com.example.core_network_api.NetworkComponentApi
import dagger.Component

@Component(modules = [NetworkModule::class])
interface NetworkComponentImpl: NetworkComponentApi {
    @Component.Factory
    interface Factory{
        fun create(): NetworkComponentImpl
    }
    companion object{

        @Volatile
        private var instance: NetworkComponentImpl? = null

        fun initAndGet(): NetworkComponentImpl {
            return instance ?: synchronized(this) {
                instance ?: DaggerNetworkComponentImpl.factory().create().also { instance = it }
            }
        }
    }
}