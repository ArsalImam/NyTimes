package com.sample.nytimes.data.beans

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.apache.commons.lang.StringUtils
import org.apache.commons.lang.math.NumberUtils

@Parcelize
data class MediaMetadata(
    var format: String? = StringUtils.EMPTY,
    var height: Int? = NumberUtils.INTEGER_ZERO,
    var url: String? = StringUtils.EMPTY,
    var width: Int? = NumberUtils.INTEGER_ZERO
) : Parcelable