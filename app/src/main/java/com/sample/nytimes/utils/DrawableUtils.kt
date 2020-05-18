package com.sample.nytimes.utils

import android.text.style.ImageSpan
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.sample.nytimes.NyTimesApp
import org.apache.commons.lang.math.NumberUtils


/**
 * [author] by `Arsal Imam`
 * [created] on 5/18/2020
 *
 * utility class to manage drawable resources
 */
object DrawableUtils {
    /**
     * this will create [ImageSpan] from drawables
     * [drawableRes] of which span needs to be create
     */
    fun toImageSpan(@DrawableRes drawableRes: Int): ImageSpan {
        val d = ContextCompat.getDrawable(NyTimesApp.INSTANCE, drawableRes)
        d!!.setBounds(
            NumberUtils.INTEGER_ZERO,
            NumberUtils.INTEGER_ZERO,
            d.intrinsicWidth,
            d.intrinsicHeight
        )
        return ImageSpan(d, ImageSpan.ALIGN_BASELINE)
    }
}