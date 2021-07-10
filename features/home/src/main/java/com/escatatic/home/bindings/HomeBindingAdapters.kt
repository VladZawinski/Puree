package com.escatatic.home.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("bindCoverImage")
fun bindCoverImage(imageView: ImageView,url: String?) {
    if(url != null){
        Glide.with(imageView)
            .load(url)
            .centerCrop()
            .into(imageView)
    }
}