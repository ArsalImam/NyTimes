package com.sample.nytimes

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.nytimes.generics.BaseAdapter

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
}