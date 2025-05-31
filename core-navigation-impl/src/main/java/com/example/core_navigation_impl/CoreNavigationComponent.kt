package com.example.core_navigation_impl

import android.app.Activity
import com.example.core_navigation_api.NavigationApi

abstract class CoreNavigationComponent : NavigationApi {
companion object{

    @Volatile
    private var coreNavigationComponent: CoreNavigationComponent? = null

    fun initAndGet(): CoreNavigationComponent? {
        return when (coreNavigationComponent){
            null ->{TODO()}
            else -> coreNavigationComponent
        }
    }


}
    abstract fun inject(activity: Activity)
}