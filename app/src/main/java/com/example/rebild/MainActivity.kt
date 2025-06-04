package com.example.rebild

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.feature_products_impl.presentation.ProductsFragment
import com.example.rebild.di.MyApp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            (application as MyApp).appComponent.componentInjector().createProductsComponent(this.application)
            (application as MyApp).appComponent.componentInjector().createPDPComponent(this.application)
            (application as MyApp).appComponent.componentInjector().createCartComponent(this.application)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, ProductsFragment())
                .commit()
        }
    }
}