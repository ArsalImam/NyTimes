package com.sample.nytimes

import android.text.Spannable
import android.text.SpannableString
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.nytimes.generics.BaseAdapter
import com.sample.nytimes.utils.Constants.SPACE
import com.sample.nytimes.utils.DrawableUtils
import com.sample.nytimes.utils.TimeUtils
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import org.apache.commons.lang.math.NumberUtils

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * binding adapters for xml bindings
 */
object BindingAdapters {

    /**
     * this can be used in xml xml attribute to set list in recycler view's adapter
     * [recyclerView] view to bind
     * [list] datasource for the adapter
     */
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

    /**
     * this can be used in xmlattribute to load image from network via url,
     * this will also transforms the loaded bitmap into circle
     *
     * [imageView] view to bind
     * [url] from which image needs to load
     */
    @BindingAdapter("app:circleImage")
    @JvmStatic
    fun loadCircleImage(imageView: ImageView, url: String) {
        Picasso.get().load(url).transform(CropCircleTransformation()).placeholder(R.color.bg_grey)
            .into(imageView)
    }

    /**
     * this can be used in xmlattribute to load image from network via url,
     *
     * [imageView] view to bind
     * [url] from which image needs to load
     */
    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {
        Picasso.get().load(url).placeholder(R.color.bg_grey).into(imageView)
    }

    /**
     * this can be used in xml attribute to qoute text in text view,
     *
     * [textView] view to bind
     * [text] to quote
     */
    @BindingAdapter("app:quotedText")
    @JvmStatic
    fun quotedText(textView: TextView, text: String) {
        val spannableString = SpannableString(SPACE + text + SPACE)
        spannableString.setSpan(
            DrawableUtils.toImageSpan(R.drawable.ic_quote_start),
            NumberUtils.INTEGER_ZERO,
            NumberUtils.INTEGER_ONE,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            DrawableUtils.toImageSpan(R.drawable.ic_quote_end),
            text.length,
            text.length + NumberUtils.INTEGER_ONE,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        )
        textView.text = spannableString
    }

    /**
     * this can be used in xml attribute to show human understandle time difference,
     *
     * [textView] view to bind
     * [text] to calculate time
     */
    @BindingAdapter("app:timeAgo")
    @JvmStatic
    fun timeAgo(textView: TextView, text: String) {
        textView.text =
            String.format(
                textView.context.getString(R.string.posted),
                TimeUtils.getTimeAgo(textView.context.resources, text)
            )
    }
}