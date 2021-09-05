package com.example.kotlincleanarchitecture.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(view: ImageView, url: String) {
            val glide = Glide.with(view)
            val target = glide.asBitmap().load(url).submit()
            CoroutineScope(Dispatchers.IO).launch {
                val bitmap = target.get()
                launch(Dispatchers.Main) {
                    view.setImageBitmap(bitmap)
                    glide.clear(view)
                }
            }
        }
    }
}