package com.example.feature_products_impl.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.feature_products_impl.R



class ProductAdapter(
    private val onItemClick: (String) -> Unit,
    private val onFavoriteClick: (String, Boolean) -> Unit,
    private val onCartCountChanged: (String, Int) -> Unit
) : ListAdapter<ProductInListVO, ProductViewHolder>(ProductDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_item, parent, false)
        return ProductViewHolder(view, onItemClick, onFavoriteClick, onCartCountChanged)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }

    private class ProductDiffCallback : DiffUtil.ItemCallback<ProductInListVO>() {
        override fun areItemsTheSame(oldItem: ProductInListVO, newItem: ProductInListVO): Boolean {
            return oldItem.guid == newItem.guid
        }

        override fun areContentsTheSame(
            oldItem: ProductInListVO,
            newItem: ProductInListVO
        ): Boolean {
            return oldItem == newItem
        }

        override fun getChangePayload(oldItem: ProductInListVO, newItem: ProductInListVO): Any? {

            val patLoad = mutableMapOf<String, Any>()
            if (oldItem.isFavorite != newItem.isFavorite) {
                patLoad["isFavorite"] = newItem.isFavorite
            }
            if (oldItem.inCartCount != newItem.inCartCount) {
                patLoad["cartCount"] = newItem.inCartCount
            }
            if (oldItem.count != newItem.count) {
                patLoad["Count"] = newItem.count
            }
            return patLoad.ifEmpty { null }
        }
    }
}
