package com.sample.nytimes

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.nytimes.generics.BaseAdapter
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 */
object BindingAdapters {

    @BindingAdapter("app:items")
    @JvmStatic
    @Suppress("UNCHECKED_CAST")
    fun setItems(recyclerView: RecyclerView, list: List<Any>?) {
        if (list == null) return
        recyclerView.adapter?.let {
            with(recyclerView.adapter as BaseAdapter<Any>) {
                items = list
            }
        }
    }

    @BindingAdapter("app:circleImage")
    @JvmStatic
    @Suppress("UNCHECKED_CAST")
    fun loadCircleImage(imageView: ImageView, url: String) {
        Picasso.get().load(url).transform(CropCircleTransformation()).placeholder(R.color.bg_grey)
    }
}