package com.example.core_navigation_impl

import com.example.core_navigation_api.NavigationApi
import dagger.Component


@Component
interface NavigationComponent : NavigationApi {


    @Component.Factory
    interface Factory{
        fun create(): NavigationComponent
    }

    companion object{

        @Volatile
        private var coreNavigationComponent: NavigationComponent? = null

        fun initAndGet(): NavigationComponent? {
            return when (coreNavigationComponent){
                null ->{TODO()}
                else -> coreNavigationComponent
            }
        }


    }
}