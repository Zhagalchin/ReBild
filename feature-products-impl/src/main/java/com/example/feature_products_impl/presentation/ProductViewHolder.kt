package com.example.feature_products_impl.presentation

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.feature_products_api.presentation.ProductInListVO
import com.example.feature_products_impl.R


class ProductViewHolder(
    itemView: View,
    private val onItemClick: (String) -> Unit,
    private val onFavoriteClick: (String, Boolean) -> Unit,
    private val onCartCountChanged: (String, Int) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val productImageView: ImageView = itemView.findViewById(R.id.productIV)
    private val productNameTextView: TextView = itemView.findViewById(R.id.nameTV)
    private val productPriceTextView: TextView = itemView.findViewById(R.id.priceTV)
    private val productRatingBar: RatingBar = itemView.findViewById(R.id.ratingView)
    private val countTV: TextView = itemView.findViewById(R.id.count_tv)
    private val isFavoriteIcon: ImageView = itemView.findViewById(R.id.imageView)
    private val addToCartButton: AddToCartButton = itemView.findViewById(R.id.addToCardBtn)



    fun bind(product: ProductInListVO){
        productNameTextView.text = product.name
        productPriceTextView.text = itemView.context.getString(R.string.prise_format, product.price)
        countTV.text = itemView.context.getString(R.string.count_format_holder, product.count)
        val image = if (product.isFavorite){
            R.drawable.like_svgrepo_com
        }else{
            R.drawable.like_heart_social_shape_outline_svgrepo_com
        }
        isFavoriteIcon.setImageResource(image)
        isFavoriteIcon.setOnClickListener {
                val newState = !product.isFavorite
                onFavoriteClick(product.guid, newState)
            }


        Glide.with(itemView.context)
            .load(product.image)
            .into(productImageView)
        itemView.setOnClickListener {
            onItemClick(product.guid) // Передаем ID товара
        }
        addToCartButton.inCartCount = product.inCartCount
        Log.d("inCartCount", product.inCartCount.toString())
        addToCartButton.onCountChanged = {newCount->
            onCartCountChanged(product.guid, newCount)
        }

        productRatingBar.rating = product.rating.toFloat()

    }

}