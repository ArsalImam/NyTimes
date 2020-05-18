package com.sample.nytimes.utils

import android.text.style.ImageSpan
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.sample.nytimes.NyTimesApp


/**
 * [author] by `Arsal Imam`
 * [created] on 5/18/2020
 */
object DrawableUtils {
    fun toImageSpan(@DrawableRes drawableRes: Int): ImageSpan {
        val d = ContextCompat.getDrawable(NyTimesApp.INSTANCE, drawableRes)
        d!!.setBounds(0, 0, d!!.intrinsicWidth, d!!.intrinsicHeight)
        return ImageSpan(d!!, ImageSpan.ALIGN_BASELINE)
    }
}