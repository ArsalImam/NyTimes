package com.sample.nytimes

import android.text.Spannable
import android.text.SpannableString
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.nytimes.generics.BaseAdapter
import com.sample.nytimes.utils.DrawableUtils
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import org.apache.commons.lang.math.NumberUtils


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
    fun loadCircleImage(imageView: ImageView, url: String) {
        Picasso.get().load(url).transform(CropCircleTransformation()).placeholder(R.color.bg_grey)
            .into(imageView)
    }

    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {
        Picasso.get().load(url).placeholder(R.color.bg_grey).into(imageView)
    }

    @BindingAdapter("app:quotedText")
    @JvmStatic
    fun quotedText(textView: TextView, text: String) {
        val spannableString = SpannableString(text)
        spannableString.setSpan(
            DrawableUtils.toImageSpan(R.drawable.ic_quote_start),
            NumberUtils.INTEGER_ZERO,
            NumberUtils.INTEGER_ZERO,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            DrawableUtils.toImageSpan(R.drawable.ic_quote_end),
            text.length - NumberUtils.INTEGER_ONE,
            text.length,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        )
        textView.text = spannableString
    }
}