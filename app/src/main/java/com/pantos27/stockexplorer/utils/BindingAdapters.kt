package com.pantos27.stockexplorer.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl", "placeholder")
fun loadImage(view: ImageView, url: String, placeholder: Drawable) {
    view.load(url){
        placeholder(placeholder)
        error(placeholder)
        crossfade(true)
    }
}

