package com.example.feature_products_api.di

import com.example.core_database_api.DatabaseComponentApi
import com.example.core_network_api.NetworkComponentApi


interface ProductsFeatureDeps  {

    fun getNetwork(): NetworkComponentApi
    fun getDataBase(): DatabaseComponentApi
}